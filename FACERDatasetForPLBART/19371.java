		@Override
		protected Cursor doInBackground(Boolean... params) {
			


            if (mPlaybackRouteId==Common.PLAY_ALL_IN_FOLDER)
                //Return a cursor directly from MediaStore.
                return MediaStoreAccessHelper.getAllSongsWithSelection(mContext,
                                                                       mQuerySelection,
                                                                       null,
                                                                       MediaStore.Audio.Media.DATA + " ASC");

            else
                return mApp.getDBAccessHelper().getPlaybackCursor(mContext, mQuerySelection, mPlaybackRouteId);

			
		}

