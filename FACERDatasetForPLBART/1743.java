    /** Performing this check in onResume() covers the case in which BT was
       not enabled during onStart(), so we were paused to enable it...
       onResume() will be called when ACTION_REQUEST_ENABLE activity returns. 
     * */
    public void onResume(){
    	// Only if the state is STATE_NONE, do we know that we haven't started already
        if (_instance.getState() == BluetoothChatService.STATE_NONE) {
          // Start the Bluetooth chat services
          _instance.start();
        }
    }

