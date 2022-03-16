    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==BlueHelper.REQUEST_ENABLE_BT && resultCode==RESULT_CANCELED)
        {
            Utils.showToast(this,"Please turn on the Bluetooth");
            return;
        }

        if (requestCode==BlueHelper.REQUEST_ENABLE_BT && resultCode==RESULT_OK)
        {
            if (device_other.getBondState()!=BluetoothDevice.BOND_BONDED)
            {
                device_other.createBond();
                return;
            }

            startThread(MODE_CONNECT);
            btn_connect.setEnabled(false);
        }


    }

