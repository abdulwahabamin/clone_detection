    private void initializePeekPlayer() {
        if(playQueue!=null) {
            if(findViewById(R.id.peek_player) == null) {
                peekPlayerParent.addView(peekPlayer);
            }
            binder.registerSongListener(this);
            if(binder.isPlaying()) {
                showPause();
            } else {
                binder.restoreSavedQueue();
                peekPlayerSeekBar.setProgress(binder.getSeek());
                showPlay();
            }
            Song song = playQueue.getCurrentPlaying();
            changeTrackInfo(song);
        } else {
            if(findViewById(R.id.peek_player) != null) {
                peekPlayerParent.removeView(peekPlayer);
            }
        }
    }

