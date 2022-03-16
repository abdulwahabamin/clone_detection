    public static boolean isBleEnable(Context context){
        if(!isSupportBle(context)){
            return false;
        }
        BluetoothManager manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        return manager.getAdapter().isEnabled();
    }

