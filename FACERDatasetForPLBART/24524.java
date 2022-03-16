    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;

        finish();
    }

