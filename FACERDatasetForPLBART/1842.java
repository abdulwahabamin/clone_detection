    public void searchForPairedDevices() {

        Set<BluetoothDevice> devices= BlueHelper.getAllPairedDevices();

        //this.devices.addAll(devices);
        for (BluetoothDevice device:devices) {
            try {
                if (device.getBluetoothClass().getDeviceClass() != BluetoothClass.Device.PHONE_SMART) {
                    return;
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }

            this.devices.add(device);
            this.states.add(false);
        }
        sAdapter.notifyDataSetChanged();
    }

