    public void init(Context context, BLEDiscoverCallback bleCallback){
        mContext = context;
        mBleDiscoveryCallback = bleCallback;
        if( context == null){
            mBleDiscoveryCallback.onInitFailure("Invalid Context!");
            return;
        }
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = mBluetoothManager.getAdapter();
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()){
            mBleDiscoveryCallback.onInitFailure("Bluetooth not supported in this device!!");
            return;
        }

        if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            mBleDiscoveryCallback.onInitFailure("Bluetooth LE is not supported in this devices!!");
            return;
        }


        mBleDiscoveryCallback.onInitSuccess();
    }

