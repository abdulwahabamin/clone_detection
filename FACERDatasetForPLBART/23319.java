    @Override
    public void onStart() {
        super.onStart();
        paused = false;

        if (false == MusicUtils.bindToService(this, osc)) {
            // something went wrong
            mHandler.sendEmptyMessage(QUIT);
        }

        IntentFilter f = new IntentFilter();
        f.addAction(MediaPlaybackService.PLAYSTATE_CHANGED);
        f.addAction(MediaPlaybackService.META_CHANGED);
        f.addAction(MediaPlaybackService.PLAYBACK_COMPLETE);
        f.addAction(MediaPlaybackService.REFRESH_PROGRESSBAR);
        f.addAction(MediaPlaybackService.TRACK_END);
        registerReceiver(mStatusListener, new IntentFilter(f));
        updateTrackInfo();
        long next = refreshNow();
        queueNextRefresh(next);
    }

