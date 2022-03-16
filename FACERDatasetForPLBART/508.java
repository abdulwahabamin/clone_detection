    @Override
    protected void onDestroy() {
        if(mProgressDialog != null){
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        if(mBluetoothChatHelper != null){
            mBluetoothChatHelper.stop();
            mBluetoothChatHelper = null;
        }
        super.onDestroy();
    }

