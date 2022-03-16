        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {

            setIsMediaPlayerPrepared(true);

            getMediaPlayer().setOnCompletionListener(onMediaPlayerCompleted);

            if (checkAndRequestAudioFocus() == true) {

                if (mFirstRun) {
                    startMediaPlayer();
                    mFirstRun = false;
                }

            } else {
                return;
            }

        }

