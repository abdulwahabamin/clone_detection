    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void handleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }

        String action = intent.getAction();
        songDTOs = PlayBackUtil.getCurrentPlayList();

        currentPosition = PlayBackUtil.getCurrentSongPosition();
        rhythmSong = MusicDataUtility.getSongMeta(songDTOs.get(currentPosition).getSongLocation());

        if (action.equalsIgnoreCase(Constants.ACTION_PLAY)) {
            mController.getTransportControls().play();
        } else if (action.equalsIgnoreCase(Constants.ACTION_PAUSE)) {
            mController.getTransportControls().pause();
        } else if (action.equalsIgnoreCase(Constants.ACTION_PREVIOUS)) {
            mController.getTransportControls().skipToPrevious();
        } else if (action.equalsIgnoreCase(Constants.ACTION_NEXT)) {
            mController.getTransportControls().skipToNext();
        } else if (action.equalsIgnoreCase(Constants.ACTION_STOP)) {
            mController.getTransportControls().stop();
        }
    }

