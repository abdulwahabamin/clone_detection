    @SuppressLint("SetTextI18n")
    public void onClickRead(View v){
        if(mBluetoothLeService != null) {
            mBluetoothLeService.readCustomCharacteristic();
           mDataField.setText(data_read="test");
           Log.e("data_read",""+data_read);
        }
    }

