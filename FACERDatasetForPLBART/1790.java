    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSocketReceived(SocketEvent socketEvent)
    {
//        if (connection==null) {

            Utils.log("requesting new bservice on socket received");
            connection = MyApplication.getBLUETOOTHSERVICE(socketEvent.socket,macAddress_other,name_other);
        //}

        onChatConnected();
    }

