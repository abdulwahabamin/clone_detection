    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothReceiver);
        if (isClient) {
            clientService.cancel();
        }

    }

