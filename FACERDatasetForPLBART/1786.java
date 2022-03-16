    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.action_connect) {
            if (isConnected) {
                MyApplication.closeBluetoothService(macAddress_other);
                connection=null;
            } else {

                if (!BlueHelper.getBluetoothAdapter().isEnabled())
                {
                    BlueHelper.init(this);
                    return true;
                }

                if (device_other.getBondState()!=BluetoothDevice.BOND_BONDED)
                {
                    device_other.createBond();
                    return true;
                }
                startThread(MODE_CONNECT);
            }
            
            btn_connect.setEnabled(false);
        }else if (item.getItemId()==android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

