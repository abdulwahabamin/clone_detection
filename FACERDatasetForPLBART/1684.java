    @Override
    public synchronized void onResume() {
        super.onResume();
       

       
        if (mChatService != null) {
          
            if (mChatService.getState() == BluetoothChatService.STATE_NONE) {
            
              mChatService.start();
            }
        }
    }

