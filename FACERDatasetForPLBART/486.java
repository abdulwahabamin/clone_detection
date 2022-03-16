    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                BluetoothAdapter.getDefaultAdapter().startDiscovery();
                LogUtils.i("Start Scan");
                mScanPb.setVisibility(View.VISIBLE);
            } else{
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

