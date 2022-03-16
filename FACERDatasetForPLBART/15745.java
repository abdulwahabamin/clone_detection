    @Override
    public void onPause() {
        super.onPause();
        if(binder != null) {
            binder.unregisterSongListener(this);
        }
        binder = null;
        this.unbindService(serviceConnection);
    }

