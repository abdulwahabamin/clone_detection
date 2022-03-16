    private void wearBroadcast(DataMap dataMap) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra("wear_data", dataMap.toBundle());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

