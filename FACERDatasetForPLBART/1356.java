        @Override
        public void onScanResult(BluetoothDevice device, int rssi) {
            BLEDevice bleDevice = new BLEDevice(device.getName(), device.getAddress(), rssi);
            for(int i=0; i < mNewDevicesArrayAdapter.getCount(); ++i){
                if( mNewDevicesArrayAdapter.getItem(i).mAddress.compareTo(device.getAddress()) == 0 ){
                    return;
                }
            }

            mNewDevicesArrayAdapter.add(bleDevice);
            mNewDevicesArrayAdapter.sort(new Comparator<BLEDevice>() {
                @Override
                public int compare(BLEDevice first, BLEDevice second) {
                    return first.mRssi > second.mRssi ? first.mRssi : second.mRssi;
                }
            });
        }

