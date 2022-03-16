    private void sendStream(){
        if(mBleMode == BLEMode.PERIPHERAL ){
            BLEPeripheralHelper.getInstance().sendStream();
        }else if(mBleMode == BLEMode.CENTRAL){
            BLECentralHelper.getInstance().sendData();
        }
    }

