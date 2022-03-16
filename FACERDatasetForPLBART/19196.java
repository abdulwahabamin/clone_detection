		@Override
		protected Void doInBackground(Void... params) {
            if (mFragmentId==Common.PLAYLISTS_FRAGMENT)
                mCursor = MediaStoreAccessHelper.getAllUniquePlaylists(mContext);
            else
                mCursor = mApp.getDBAccessHelper().getFragmentCursor(mContext, mQuerySelection, mFragmentId);

            loadDBColumnNames();
	        return null;
		}

