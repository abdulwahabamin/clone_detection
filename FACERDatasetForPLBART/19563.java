        @Override
        public void onServiceCursorReady(Cursor cursor, int currentSongIndex, boolean playAll) {

            if (cursor.getCount()==0) {
                Toast.makeText(mContext, R.string.no_audio_files_found, Toast.LENGTH_SHORT).show();
                if (mApp.getNowPlayingActivity()!=null)
                    mApp.getNowPlayingActivity().finish();

                return;
            }

            setCursor(cursor);
            setCurrentSongIndex(currentSongIndex);
            getFailedIndecesList().clear();
            initPlaybackIndecesList(playAll);
            mFirstRun = true;
            prepareMediaPlayer(currentSongIndex);
            //Notify NowPlayingActivity to initialize its ViewPager.
            mApp.broadcastUpdateUICommand(new String[] { Common.INIT_PAGER },
                    new String[] { "" });
        }

