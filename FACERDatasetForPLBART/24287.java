    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter f = new IntentFilter();
        f.addAction(MediaPlaybackService.META_CHANGED);
        f.addAction(MediaPlaybackService.QUEUE_CHANGED);
        registerReceiver(mStatusListener, new IntentFilter(f));
    }

