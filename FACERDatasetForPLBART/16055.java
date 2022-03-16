    private void initializePlayer(){
        binder.registerSongListener(this);
        Intent intent = getActivity().getIntent();

        if(intent.hasExtra(PlayerActivity.EXTRA_PLAY_QUEUE)) {
            PlayQueue playQueue = intent.getParcelableExtra(PlayerActivity.EXTRA_PLAY_QUEUE);
            intent.removeExtra(PlayerActivity.EXTRA_PLAY_QUEUE);
            binder.newQueue(playQueue);
        } else if(intent.hasExtra(PlayerActivity.EXTRA_CHANGE_TRACK)) {
            int index = intent.getIntExtra(PlayerActivity.EXTRA_CHANGE_TRACK, 0);
            intent.removeExtra(PlayerActivity.EXTRA_CHANGE_TRACK);
            changeTrack(index);
        } else {
            changeSongInfo(Global.playQueue.getCurrentPlaying(), rootView);
            if(binder.isPlaying()) {
                showPause();
            } else {
                binder.restoreSavedQueue();
                seekBar.setProgress(binder.getSeek());
            }
        }
    }

