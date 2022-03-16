    @Override
    public void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter();
        filter.addAction(MediaPlaybackService.META_CHANGED);
        filter.addAction(MediaPlaybackService.QUEUE_CHANGED);
        getActivity().registerReceiver(mNowPlayingListener, filter);
    }

