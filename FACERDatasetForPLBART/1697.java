    private synchronized void setState(int state) {
     
        mState = state;

      
        mHandler.obtainMessage(BluetoothChat.MESSAGE_STATE_CHANGE, state, -1).sendToTarget();
    }

