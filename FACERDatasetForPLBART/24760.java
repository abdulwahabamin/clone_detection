        @Override
        public void onClick(View v) {
            if (RunServiceIfnot(SongPlayback.isPlayFromMainTrue,MainActivity.forNextKey,0))
                PlayerConstants.mSongPlayback.skipToNextTrack();

        }

