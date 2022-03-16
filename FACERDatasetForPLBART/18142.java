    @Override
    protected void onProgressUpdate(Integer... values) {
    	super.onProgressUpdate(values);
    	int value = values[0];
    	
    	switch(value) {
    	case 0:
			Intent intent = new Intent(mContext, NowPlayingActivity.class);
			
			//Get the parameters for the first song.
			if (mCursor.getCount() > 0) {
				mCursor.moveToFirst();
				
				if (mEnqueueType.equals("ARTIST")) {
					intent.putExtra("PLAY_ALL", "ARTIST");
					intent.putExtra("CALLING_FRAGMENT", "ARTISTS_FLIPPED_FRAGMENT");
				} else if (mEnqueueType.equals("ALBUM_ARTIST")) {
					intent.putExtra("PLAY_ALL", "ALBUM_ARTIST");
					intent.putExtra("CALLING_FRAGMENT", "ALBUM_ARTISTS_FLIPPED_FRAGMENT");
				} else if (mEnqueueType.equals("ALBUM")) {
					intent.putExtra("PLAY_ALL", "ALBUM");
					intent.putExtra("CALLING_FRAGMENT", "ALBUMS_FLIPPED_FRAGMENT");
				} else if (mEnqueueType.equals("PLAYLIST")) {
					intent.putExtra("CALLING_FRAGMENT", "PLAYLISTS_FLIPPED_FRAGMENT");
					intent.putExtra("PLAYLIST_NAME", mPlaylistName);
				} else if (mEnqueueType.equals("GENRE")) {
					intent.putExtra("PLAY_ALL", "GENRE");
					intent.putExtra("CALLING_FRAGMENT", "GENRES_FLIPPED_FRAGMENT");
				} else if (mEnqueueType.equals("ALBUM_ARTIST")) {
					intent.putExtra("CALLING_FRAGMENT", "ALBUM_ARTISTS_FLIPPED_FRAGMENT");
					intent.putExtra("PLAY_ALL", "ALBUM_ARTIST");
				} else if (mEnqueueType.equals("SONG")) {
					intent.putExtra("CALLING_FRAGMENT", "SONGS_FRAGMENT");
					intent.putExtra("SEARCHED", true);
				} else if (mEnqueueType.equals("ALBUM_BY_ALBUM_ARTIST")) {
					intent.putExtra("CALLING_FRAGMENT", "ALBUM_ARTISTS_FLIPPED_SONGS_FRAGMENT");
					intent.putExtra("PLAY_ALL", "ALBUM");
				}

    			intent.putExtra("SELECTED_SONG_DURATION", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_DURATION)));
				intent.putExtra("SELECTED_SONG_TITLE", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_TITLE)));
				intent.putExtra("SELECTED_SONG_ARTIST", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ARTIST)));
				intent.putExtra("SELECTED_SONG_ALBUM", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM)));
				intent.putExtra("SELECTED_SONG_ALBUM_ARTIST",  mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_ALBUM_ARTIST)));
				intent.putExtra("SONG_SELECTED_INDEX", 0);
				intent.putExtra("SELECTED_SONG_DATA_URI", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_FILE_PATH)));
				intent.putExtra("SELECTED_SONG_GENRE", mCursor.getString(mCursor.getColumnIndex(DBAccessHelper.SONG_GENRE)));
				intent.putExtra("NEW_PLAYLIST", true);
				intent.putExtra("NUMBER_SONGS", mCursor.getCount());
				intent.putExtra("CALLED_FROM_FOOTER", false);
				intent.putExtra(Common.CURRENT_LIBRARY, mApp.getCurrentLibrary());
				
			} else {
				Toast.makeText(mContext, R.string.error_occurred, Toast.LENGTH_LONG).show();
				break;
			}
			
			mFragment.getActivity().startActivity(intent);
			mFragment.getActivity().overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    		break;
    	case 1:
    		int numberOfSongs = mCursor.getCount();
    		String toastMessage = "";
    		if (numberOfSongs==1) {
    			if (mPlayNext) {
    				toastMessage = mPlayingNext + " " + mContext.getResources().getString(R.string.will_be_played_next);
    			} else {
    				toastMessage = numberOfSongs + " " + mContext.getResources().getString(R.string.song_enqueued_toast);
    			}
    			
    		} else {
    			if (mPlayNext) {
    				toastMessage = mPlayingNext + " " + mContext.getResources().getString(R.string.will_be_played_next);
    			} else {
    				toastMessage = numberOfSongs + " " + mContext.getResources().getString(R.string.songs_enqueued_toast);
    			}
    			
    		}
    		
    		Toast.makeText(mContext, toastMessage, Toast.LENGTH_SHORT).show();
    		break;
    	}
    	
    }

