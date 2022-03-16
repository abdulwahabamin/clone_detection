    @Override
    public void onItemClick(int position) {
        //  RealmManager.getRealm().where(BluetoothDeviceWrapper.class).findAll().deleteAllFromRealm();

        BlueHelper.getBluetoothAdapter().cancelDiscovery();

        startActivity(new Intent(this,ChatActivity.class)
                .putExtra(Constants.MAC_ADDRESS, devices.get(position).getAddress())
                .putExtra(Constants.NAME, devices.get(position).getName())
        );
        finish();
    }

