    public void onServiceDisconnected(ComponentName name) {
        service = null;

        playerHeaderFragment.onServiceDisconnected();
        playQueueFragment.onServiceDisconnected();
        playerFooterFragment.onServiceDisconnected();

        finish();
    }

