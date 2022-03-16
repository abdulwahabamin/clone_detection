    /**
     * Notifies via events to all registered listeners in the Advertising phase.
     *
     * @param action
     * @param data
     */

    private void notifyChatListeners(NotifyChatAction action, Object data) {
        for (BLEPeripheralChatEvents listener : mChatListeners) {
            switch (action) {
                case NOTIFY_CHAT_ACTION_MESSAGE:
                    listener.onMessage((String) data);
                    break;
                case NOTIFY_CHAT_ACTION_INFO:
                    listener.onInfo((String) data);
                    break;
                case NOTIFY_CHAT_ACTION_CLIENT_DISCONNECT:
                    listener.onClientDisconnect((BluetoothDevice) data);
                    break;
                case NOTIFY_CHAT_ACTION_CONNECTION_ERROR:
                    listener.onConnectionError((String) data);
                    break;
                case NOTIFY_CHAT_ACTION_INIT_RFCOMM_SOCKET:
                    listener.onInitRfcommSocket();
                    break;
                case NOTIFY_CHAT_ACTION_CONNECT_RFCOMM_SOCKET:
                    listener.onConnectRfcommSocket();
                    break;
                case NOTIFY_CHAT_ACTION_DATA_RFCOMM_SOCKET:
                    listener.onData((byte [])data);
                    break;
                case NOTIFY_CHAT_ACTION_BLE_STREAM:
                    listener.onDataStream((byte [])data);
            }
        }
    }

