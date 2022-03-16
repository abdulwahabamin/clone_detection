    private void startScanner() {

        if (!BlueHelper.getBluetoothAdapter().isEnabled())
        {
            BlueHelper.init(this);
            return;
        }

        devices.clear();
        states.clear();
        searchForPairedDevices();
        BlueHelper.startDiscovery();
        BlueHelper.setDiscoverable(this);
        scan.setText("Scanning...");
        scan.setEnabled(false);
        unlockScan();
    }

