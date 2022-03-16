    @Override
    protected synchronized void onResume() {
        super.onResume();
        if (mConnService != null) {
            if (mConnService.getState() == BluetoothConnectionService.STATE_NONE) {
                mConnService.start();
            }
        }

    }

