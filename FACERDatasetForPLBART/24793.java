        @Override
        public void run() {
            if (PlayerConstants.SONG_NUMBER>-1)
            {
                changeUI();
                updateImage();
            }
            setupMusicPlayer();
        }

