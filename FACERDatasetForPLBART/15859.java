    private void updateLostClients(Collection<WifiP2pDevice> newClientList,
                                   final GroupMemberListener groupMemberListener){
        if(groupMemberListener == null) {
            return;
        }
        //check only if any established clients left

        ArrayList<String> devicesToRemove = new ArrayList<>();

        outerLoop:
        for(String deviceAddress : clientMap.keySet()){
            for(WifiP2pDevice device : newClientList) {
                if(deviceAddress.equals(device.deviceAddress)) continue outerLoop;
            }
            groupMemberListener.onMemberLeft(deviceAddress);
            devicesToRemove.add(deviceAddress);
        }

        for(String deviceAddress : devicesToRemove) {
            clientMap.remove(deviceAddress);
        }

        for(final String leftClientAddress : devicesToRemove) {
            handler.executeAsync(new Runnable() {
                @Override
                public void run() {
                    sendClientLeftNotification(leftClientAddress);
                }
            }, THREAD_CLIENT_HANDLER);
        }
    }

