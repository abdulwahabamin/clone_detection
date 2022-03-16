        @Override
        public void run() {
            Cursor cursor= MediaStoreAccessHelper.getAllSongs(mContext, null, null);
            if (cursor.getCount()>0)
            {
                if (PlayerConstants.SONG_NUMBER+1>cursor.getCount())
                    PlayerConstants.SONG_NUMBER=-1;
                else
                    mHandler.postDelayed(setLastposition,200);
            }
            else
            {
                PlayerConstants.SONG_NUMBER=-1;
            }
        }

