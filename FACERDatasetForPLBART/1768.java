    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case Constants.MESSAGE_STATE_CHANGE:
            if(Constants.D) Log.i(Constants.TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
            switch (msg.arg1) {
            case BluetoothChatService.STATE_CONNECTED:                    
                mConversationArrayAdapter.clear();
                break;
            case BluetoothChatService.STATE_CONNECTING:
                break;
            case BluetoothChatService.STATE_LISTEN:
            	
            case BluetoothChatService.STATE_NONE:
                break;
            }
            break;
        case Constants.MESSAGE_WRITE:
            byte[] writeBuf = (byte[]) msg.obj;
            // construct a string from the buffer
            String writeMessage = new String(writeBuf);
            mConversationArrayAdapter.add("Me:  " + writeMessage);
            break;
        case Constants.MESSAGE_READ:
            byte[] readBuf = (byte[]) msg.obj;
            // construct a string from the valid bytes in the buffer
            if(msg.arg1>0) {
            	String readMessage = new String(readBuf, 0, msg.arg1);
            	mConversationArrayAdapter.add(mConnectedDeviceName+":  " + readMessage);
            }
            break;
        case Constants.MESSAGE_DEVICE_NAME:
            // save the connected device's name
            mConnectedDeviceName = msg.getData().getString(Constants.DEVICE_NAME);
            Toast.makeText(context, "Connected to "
                           + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
            break;
        case Constants.MESSAGE_TOAST:
            Toast.makeText(context, msg.getData().getString(Constants.TOAST),
                           Toast.LENGTH_SHORT).show();
            break;
        }
    }

