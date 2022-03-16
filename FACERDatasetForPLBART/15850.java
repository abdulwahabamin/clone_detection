    void createGroup(final String username, final String groupName,
                     final GroupCreationListener groupCreationListener,
                     final GroupMemberListener groupMemberListener,
                     final RequestListener requestListener) {
        Map<String,String> txtMap = new HashMap<>();
        txtMap.put(RECORD_LISTEN_PORT, String.valueOf(server.getPort()));
        txtMap.put(RECORD_USER_NAME, username);
        txtMap.put(RECORD_GROUP_NAME, groupName);

        WifiP2pDnsSdServiceInfo serviceInfo =
                WifiP2pDnsSdServiceInfo.newInstance(INSTANCE_NAME, "_presence._tcp", txtMap);

        p2pManager.addLocalService(channel, serviceInfo, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG,"DnsSd service added");
            }

            @Override
            public void onFailure(final int reason) {
                Log.d(LOG_TAG, "Create service failed");
                String message = "Failed to create group. Reason: ";
                groupCreationListener.onGroupCreationFailed(message + standardErrors(reason));
            }
        });

        this.groupMemberListener = groupMemberListener; //will be used later for when new clients join and establish
        this.requestListener = requestListener; //for any incoming requests

        //to check if a member left the group
        p2pBroadcastReceiver.registerGroupInfoListener(new WifiP2pManager.GroupInfoListener() {
            @Override
            public void onGroupInfoAvailable(final WifiP2pGroup group) {
                if(group != null) {
                    updateLostClients(group.getClientList(), groupMemberListener);
                }
            }
        });

        //TODO: register connection info listener instead for group creation success


        p2pManager.createGroup(channel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG,"create group initiated");
                groupCreationListener.onGroupCreated();
                ownerDeviceAddress = p2pBroadcastReceiver.myDevice.deviceAddress;
            }

            @Override
            public void onFailure(final int reason) {
                Log.d(LOG_TAG, "Failed to create P2P Group");
                final String message = "Failed to create group. Reason: ";
                groupCreationListener.onGroupCreationFailed(message + standardErrors(reason));
            }
        });
    }

