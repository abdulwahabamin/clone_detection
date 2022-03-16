    private void callingAdvertising() {
        advertiser = BluetoothAdapter.getDefaultAdapter().getBluetoothLeAdvertiser();
        if (advertiser != null)
            advertiser.startAdvertising(settings, data, advScanResponse, advertisingCallback);

    }

