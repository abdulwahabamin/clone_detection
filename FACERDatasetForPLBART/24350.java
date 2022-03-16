    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(LOGTAG, "onNewIntent - " + intent);
        boolean addToBackStack = parseIntent(intent, false);
        if (songToPlay > -1) {
            if (service != null) {
                MusicUtils.playSong(this, songToPlay);
                songToPlay = -1;
            }
        }
        if (addToBackStack) {
            backStack.add(getIntent());
            setIntent(intent);
        }
    }

