    @Override
    public void onPause() {
        super.onPause();
        if(binder != null) {
            binder.unregisterSongListener(this);
        }
        binder = null;
        getContext().unbindService(serviceConnection);
    }

