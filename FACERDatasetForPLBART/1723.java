    @Override
    public synchronized void onResume() {
        super.onResume();
        if(Constants.D) Log.e(Constants.TAG, "+ ON RESUME +");

        // Performing this check in onResume() covers the case in which BT was
        // not enabled during onStart(), so we were paused to enable it...
        // onResume() will be called when ACTION_REQUEST_ENABLE activity returns.
        if (BluetoothChatService.isSetup()) {
        	BluetoothChatService.getIns().onResume();
        }
    }

