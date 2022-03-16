    @Override
    public void onResume() {
        super.onResume();
        IntentFilter f = new IntentFilter();
        f.addAction(MediaPlaybackService.META_CHANGED);
        registerReceiver(mStatusListener, new IntentFilter(f));
        updateMenu();
        if (mAutoShuffle) {
            mAutoShuffle = false;
            doAutoShuffle();
        }
    }

