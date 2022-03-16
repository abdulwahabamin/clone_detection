    public void connectToGroup(final String groupId,
                               final GroupConnectionListener groupConnectionListener,
                               final GroupMemberListener groupMemberListener,
                               RequestListener requestListener) {

        WifiP2pConfig config = new WifiP2pConfig();
        config.deviceAddress = groupId;
        config.wps.setup = WpsInfo.PBC;

        this.groupMemberListener = groupMemberListener;
        this.groupConnectionListener = groupConnectionListener;
        this.requestListener = requestListener;

        p2pBroadcastReceiver.registerConnectionInfoListener(
                new WifiP2pManager.ConnectionInfoListener() {
                    @Override
                    public void onConnectionInfoAvailable(WifiP2pInfo info) {
                        if(!info.groupFormed) {
                            groupConnectionListener.onConnectionFailed("Connection failed");
                            return;
                        }
                        p2pBroadcastReceiver.clearConnectionInfoListener(); //TODO: register a new one for disconnection

                        ownerDeviceAddress = groupId;
                        final int ownerPort = Integer.parseInt(
                                discoveredP2pGroups.get(groupId).record.get(RECORD_LISTEN_PORT));
                        final InetAddress ownerAddress = info.groupOwnerAddress;
                        Runnable establish = new Runnable() {
                            @Override
                            public void run() {
                                clientMap.put(groupId, new Client(ownerAddress, ownerPort));
                                try {
                                    EasyHandler.executeOnMainThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            groupConnectionListener.onConnectionSuccess(groupId);
                                        }
                                    });

                                    establish(ownerAddress, ownerPort);
                                    stopDiscovery();
                                } catch (IOException  | JSONException e) {
                                    groupConnectionListener.onConnectionFailed("IOException at establish");
                                }
                            }
                        };
                        handler.executeAsync(establish, THREAD_NETWORK_MANAGER);

                        p2pBroadcastReceiver.registerGroupInfoListener(new WifiP2pManager.GroupInfoListener() {
                            @Override
                            public void onGroupInfoAvailable(final WifiP2pGroup group) {
                                Runnable r = new Runnable() {
                                    @Override
                                    public void run() {
                                        if(group != null) {
                                            updateLostClients(group.getClientList(), groupMemberListener);
                                        }
                                    }
                                };
                                handler.executeAsync(r, THREAD_CLIENT_HANDLER);
                            }
                        });

                        p2pBroadcastReceiver.registerConnectionInfoListener(new WifiP2pManager.ConnectionInfoListener() {
                            @Override
                            synchronized public void onConnectionInfoAvailable(WifiP2pInfo info) {
                                if(!info.groupFormed) {
                                    groupConnectionListener.onOwnerDisconnected();
                                }
                            }
                        });
                    }
                });


        p2pManager.connect(channel, config, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG, "Initiating connection to: " + groupId);
            }

            @Override
            public void onFailure(final int reason) {
                final String message = "Failed to connect to group. Reason: ";
                groupConnectionListener.onConnectionFailed(message + standardErrors(reason));
            }
        });
    }

