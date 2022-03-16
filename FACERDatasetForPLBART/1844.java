    @Override
    protected void onDestroy() {
        super.onDestroy();
        permissionHelper.onDestroy();
        // Don't forget to unregister the ACTION_FOUND receiver.
        unregisterReceiver(mReceiver);
    }

