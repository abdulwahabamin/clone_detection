    public void showDevices(){
        if (mBluetoothAdapter.isEnabled()){

            scanDevicesList.clear();

            if (mBluetoothAdapter.isDiscovering()) {
                mBluetoothAdapter.cancelDiscovery();
            }
            ensureDiscoverable();
            mBluetoothAdapter.startDiscovery();

            if (mBluetoothAdapter.isDiscovering())tvScanDevices.setEnabled(false);
            else tvScanDevices.setEnabled(true);

            tvScanTitle.setText("Scanning Devices");
            if (tvEmpty.getVisibility()==View.VISIBLE)tvEmpty.setVisibility(View.GONE);
            if (llBottomButtons.getVisibility()==View.VISIBLE)llBottomButtons.setVisibility(View.GONE);
            alertDialog.show();

        }else{
            Toast.makeText(this, "Bluetooth is Not Enabled", Toast.LENGTH_SHORT).show();
        }
    }

