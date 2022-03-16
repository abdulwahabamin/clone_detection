    public LiveData<List<BluetoothDevice>> getPairedDevices() {
        Set<BluetoothDevice> pairedDevice = bluetoothAdapter.getBondedDevices();
        List<BluetoothDevice> allPairedDevices = new ArrayList<>();
        for (BluetoothDevice bluetoothDevice : pairedDevice) {
            allPairedDevices.add(bluetoothDevice);
            if (allPairedDevices.size() > 0) {
                pairedDevices.postValue(allPairedDevices);
                return pairedDevices;
            }
        }
        return null;
    }

