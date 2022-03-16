    void discoverGroups(final NewGroupListener groupListener, final ErrorListener errorListener) {
        discoveredP2pGroups = new HashMap<>();
        DnsSdTxtRecordListener txtListener = new DnsSdTxtRecordListener() {
            @Override
            public void onDnsSdTxtRecordAvailable(
                    String fullDomain, Map record, WifiP2pDevice device) {
                //TODO: improve checking if glideplayer
                //TODO: check GlidePlayer app version in case of mismatched formats in exchanging info
                if(fullDomain.substring(0, INSTANCE_NAME.length()).equals(INSTANCE_NAME)
                        && (record instanceof HashMap)) {
                    discoveredP2pGroups.put(device.deviceAddress,
                            new AvailableGroup(device, (HashMap) record));
                }
            }
        };

        DnsSdServiceResponseListener serviceListener = new DnsSdServiceResponseListener() {
            @Override
            public void onDnsSdServiceAvailable(String instanceName, String registrationType,
                                                final WifiP2pDevice srcDevice) {
                if(instanceName.equals("glideplayer")) {
                    final AvailableGroup group = discoveredP2pGroups.get(srcDevice.deviceAddress);
                    groupListener.newGroupFound(group.owner.deviceAddress,
                            group.record.get(RECORD_GROUP_NAME),
                            group.record.get(RECORD_USER_NAME),
                            srcDevice.deviceName,
                            /*TODO: get members*/1);
                }
            }
        };

        p2pManager.setDnsSdResponseListeners(channel, serviceListener, txtListener);

        discoveryRequest = WifiP2pDnsSdServiceRequest.newInstance();
        p2pManager.addServiceRequest(channel, discoveryRequest, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() { Log.d(LOG_TAG,"discovery request added"); }

            @Override
            public void onFailure(final int reason) {
                final String message = "Search failed. Reason: ";
                errorListener.error(message + standardErrors(reason));
            }
        });

        p2pManager.discoverServices(channel, new WifiP2pManager.ActionListener() {
            @Override
            public void onSuccess() {Log.d(LOG_TAG,"discover services started");}

            @Override
            public void onFailure(final int reason) {
                final String message = "Search failed. Reason: ";
                errorListener.error(message + standardErrors(reason));
                p2pManager.clearServiceRequests(channel, new WifiP2pManager.ActionListener() {
                    @Override
                    public void onSuccess() {}

                    @Override
                    public void onFailure(int reason) {
                        Log.d(LOG_TAG, "Failed to clear service requests. Reason:" + reason);
                    }
                });
            }
        });
    }

