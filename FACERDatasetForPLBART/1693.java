    public void onActivityResult(int requestCode, int resultCode, Intent data) {
   
        switch (requestCode) {
        case REQUEST_CONNECT_DEVICE:
          
            if (resultCode == Activity.RESULT_OK) {
                
                String address = data.getExtras()
                                     .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
              
                BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                
                mChatService.connect(device);
            }
            break;
        case REQUEST_ENABLE_BT:
           
            if (resultCode == Activity.RESULT_OK) {
               
                setupChat();
            } else {
               
            
                Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

