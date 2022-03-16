	/**
	 * Loads the correct fragment based on the selected browser.
	 */
	public void loadFragment(Bundle savedInstanceState) {
		//Get the target fragment from savedInstanceState if it's not null (orientation changes?).
		if (savedInstanceState!=null) {
			mCurrentFragmentId = savedInstanceState.getInt(CURRENT_FRAGMENT);
            invalidateOptionsMenu();
			
		} else {
			//Set the current fragment based on the intent's extras.
    		if (getIntent().hasExtra(CURRENT_FRAGMENT)) {
    			mCurrentFragmentId = getIntent().getExtras().getInt(CURRENT_FRAGMENT);
    		}
    		
    		switch (mCurrentFragmentId) {
    		case Common.ARTISTS_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.ARTISTS_FRAGMENT);
    			break;
    		case Common.ALBUM_ARTISTS_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.ALBUM_ARTISTS_FRAGMENT);
    			break;
    		case Common.ALBUMS_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.ALBUMS_FRAGMENT);
    			break;
    		case Common.SONGS_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.SONGS_FRAGMENT);
    			break;
    		case Common.PLAYLISTS_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.PLAYLISTS_FRAGMENT);
    			break;
    		case Common.GENRES_FRAGMENT:
    			mCurrentFragment = getLayoutFragment(Common.GENRES_FRAGMENT);
    			break;
    		case Common.FOLDERS_FRAGMENT:
    			mCurrentFragment = new FilesFoldersFragment();
    			break;
    		}
    		
    		switchContent(mCurrentFragment);
		}
		
	}

