    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
            //�?�得状�?改�?�的设备，更新设备列表信�?�（�?对状�?）
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if(device != null){
                resolveBondingState(device.getBondState());
            }
        }
    }

