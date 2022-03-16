    private void enableBLE() {
        if (mBluetoothAdapter.isEnabled()) {
            startScan();
        } else {
            mBluetoothAdapter.enable();
        }
    }

