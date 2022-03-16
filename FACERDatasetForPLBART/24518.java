    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((MediaPlaybackService.LocalBinder) binder).getService();

        getLoaderManager().initLoader(0, null, this);
    }

