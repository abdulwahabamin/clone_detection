    @Override
    public void onStart() {
        super.onStart();
        if (!bluetoothAdapter.isEnabled()) {


            Intent dIntent =  new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            dIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3000);
            startActivity(dIntent);

        } else {
            chatController = new ChatController(this, handler);
        }

    }

