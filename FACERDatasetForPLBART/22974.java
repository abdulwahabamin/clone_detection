    private boolean isBTEnabled() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!(mBluetoothAdapter == null)) {
            if (mBluetoothAdapter.isEnabled()) {
                if (isContainBTHeadphone(mBluetoothAdapter)) {
                    return true;
                }
            }
            try {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

