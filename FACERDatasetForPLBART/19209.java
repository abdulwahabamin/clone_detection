	/**
	 * Retrieves the correct fragment based on the saved layout preference.
	 */
	private Fragment getLayoutFragment(int fragmentId) {
		
		//Instantiate a new bundle.
		Fragment fragment = null;
		Bundle bundle = new Bundle();
		
		//Retrieve layout preferences for the current fragment.
		switch (fragmentId) {
		case Common.ARTISTS_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(ARTISTS_FRAGMENT_LAYOUT, GRID_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.ARTISTS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.artists));
			break;
		case Common.ALBUM_ARTISTS_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(ALBUM_ARTISTS_FRAGMENT_LAYOUT, GRID_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.ALBUM_ARTISTS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.album_artists));
			break;
		case Common.ALBUMS_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(ALBUMS_FRAGMENT_LAYOUT, GRID_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.ALBUMS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.albums));
			break;
		case Common.SONGS_FRAGMENT:
			mCurrentFragmentLayout = LIST_LAYOUT;
			bundle.putInt(Common.FRAGMENT_ID, Common.SONGS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.songs));
			break;
		case Common.PLAYLISTS_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(PLAYLISTS_FRAGMENT_LAYOUT, LIST_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.PLAYLISTS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.playlists));
			break;
		case Common.GENRES_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(GENRES_FRAGMENT_LAYOUT, GRID_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.GENRES_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.genres));
			break;
		case Common.FOLDERS_FRAGMENT:
			mCurrentFragmentLayout = mApp.getSharedPreferences().getInt(FOLDERS_FRAGMENT_LAYOUT, LIST_LAYOUT);
			bundle.putInt(Common.FRAGMENT_ID, Common.FOLDERS_FRAGMENT);
            bundle.putString(FRAGMENT_HEADER, mContext.getResources().getString(R.string.folders));
			break;
		}		
				
		//Return the correct layout fragment.
		if (mCurrentFragmentLayout==GRID_LAYOUT) {
			fragment = new GridViewFragment();
			fragment.setArguments(bundle);
		} else {
			fragment = new ListViewFragment();
			fragment.setArguments(bundle);
		}
		
		return fragment;
	}

