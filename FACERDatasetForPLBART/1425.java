        @Override
        public void onClientDisconnect(BluetoothDevice device) {
            synchronized (mLock){
                showInfo(device.getName() + " disconnected");
                setStatus(R.string.title_not_connected);
            }
        }

