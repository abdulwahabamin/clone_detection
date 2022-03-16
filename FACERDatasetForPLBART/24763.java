        @Override
        public void onClick(View v) {
            if(RunServiceIfnot(SongPlayback.isPlayFromMainFalse,MainActivity.forNothingKey,0)){
                PlayerConstants.mSongPlayback.pausePlayback();
            }
            changeButton();
        }

