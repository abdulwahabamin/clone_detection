    /**
     * Initialize RFCOMM Socket thread for Classic Bluetooth communications/transfers
     */
    public void initRfcommService() {
        if (mInsecureAcceptThread == null) {
            mInsecureAcceptThread = new AcceptThread(false);
            mInsecureAcceptThread.start();
        }
        sendTransferReady();
        notifyChatListeners(NotifyChatAction.NOTIFY_CHAT_ACTION_INIT_RFCOMM_SOCKET, null);
    }

