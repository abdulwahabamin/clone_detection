        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ClientService.CONNECTED_SUCCESS:
                    Log.i(TAG, "connected success");
                    Intent intent = new Intent(DeviceActivity.this, ChatActivity.class);
                    intent.putExtra("device", mDevice);
                    intent.putExtra("uuid", selectedUuidStr);
                    startActivity(intent);
                    break;
                case ClientService.CONNECTED_FAIL:
                    Log.i(TAG, "connected fail");
                    break;
            }
        }

