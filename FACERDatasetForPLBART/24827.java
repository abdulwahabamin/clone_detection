        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {

            //Update the prepared flag.
            setIsMediaPlayer2Prepared(true);

            //Set the completion listener for mMediaPlayer2.
            getMediaPlayer2().setOnCompletionListener(onMediaPlayer2Completed);

            //Check to make sure we have AudioFocus.
            if (checkAndRequestAudioFocus()==true) {


            } else {
                return;
            }

        }

