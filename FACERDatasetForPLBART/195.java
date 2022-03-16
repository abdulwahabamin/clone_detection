        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                list.add(device);
                Log.e(TAG, "discovery:" + device.getName());
                bleAdapter.notifyDataSetChanged();
            } else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
                // Toast.makeText(MainActivity.this, "discovery finished", Toast.LENGTH_LONG).show();
                btnSearch.setText("é‡?æ–°æ?œç´¢");
                mBluetoothAdapter.cancelDiscovery();
            }
        }

