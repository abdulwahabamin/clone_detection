        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MediaPlaybackService.META_CHANGED)) {
                // redraw the artist/title info and
                // set new max for progress bar
                updateTrackInfo();
                setPauseButtonImage();
                queueNextRefresh(1);
            } else if (action.equals(MediaPlaybackService.PLAYBACK_COMPLETE)) {
                if (mOneShot) {
                    finish();
                } else {
                    setPauseButtonImage();
                }
            } else if (action.equals(MediaPlaybackService.PLAYSTATE_CHANGED)) {
                setPauseButtonImage();
            } else if (action.equals(MediaPlaybackService.REFRESH_PROGRESSBAR)) {
                refreshNow();
            } else if (action.equals(MediaPlaybackService.TRACK_END)) {
                mFirstRefreshEvent = true;
                mSkipSeek = true;
            }
        }

