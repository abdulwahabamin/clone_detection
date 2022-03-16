    @SuppressLint("HandlerLeak")
    private void initServerService() {
        serverHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ClientService.CONNECTED_SUCCESS:
                        Log.i(TAG, "accept connected");
                        BluetoothDevice device= (BluetoothDevice) msg.obj;
                        Intent intent = new Intent(AcceptService.this, ChatActivity.class);
                        intent.putExtra("device", device);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        break;
                    case ClientService.CONNECTED_FAIL:
                        Log.i(TAG, "connected fail");
                        break;
                }
            }
        };
        serverService = ServerService.getInstance(serverHandler);

        BluetoothAdapter adapter=BluetoothAdapter.getDefaultAdapter();


        serverService.startAccept(adapter);
    }

