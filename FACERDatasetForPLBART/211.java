        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, intent.getAction());


            if (intent.getAction().equals(BluetoothDevice.ACTION_ACL_DISCONNECTED)) {
                if (clientService != null) {
                    clientService.cancel();
                }

                exitChatDialog("当�?连接已断开，请�?新连接", false);
            } else if (intent.getAction().equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    exitChatDialog("当�?连接已断开，请�?新连接", false);
                }
            }
        }

