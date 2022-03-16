        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GATT_CONNECTED:
                    bluetoothGatt.discoverServices();
                    break;

                case GATT_DISCONNECTED:
                    break;

                case GATT_SERVICES_DISCOVER:
                    updateValue();
                    break;
            }
        }

