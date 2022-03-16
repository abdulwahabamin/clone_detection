    @Override //always on a separate thread
    public Object onNewRequest(String deviceId, int action, Object requestData) {
        if(action == ACTION_GET_USERNAME) {
            currentGroup.addMember(deviceId, (String) requestData);
            return userName;
        } else if(action == NetworkService.ACTION_RAW_SOCKET) {
            exchangeLibraries(deviceId, (Socket) requestData, false);
            updateLibraryLists(deviceId);
            joinStatus = JoinStatus.CONNECTED;
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override
                public void run() {
                    for(GroupConnectionListener listener : groupConnectionListenerList) {
                        listener.onConnectionSuccess(currentGroup.groupName);
                    }
                }
            });
            return null;
        } else if(action == ACTION_GET_SONG) {
            return songRequest((Long)requestData);
        } else if(action == ACTION_NOTIFY_USERNAME_TAKEN) {
            EasyHandler.executeOnMainThread(new Runnable() {
                @Override

