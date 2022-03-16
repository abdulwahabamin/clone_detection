        public void run() {
            while (true) {
                if (mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.startDiscovery();
                    break;
                }
            }
        }

