	/**
	 * Instantiates a new fragment if mMusicFoldersSelectionFragment is null. 
	 * Returns the current fragment, otherwise.
	 */
	public MusicFoldersSelectionFragment getMusicFoldersSelectionFragment() {
		if (mMusicFoldersSelectionFragment==null) {
			mMusicFoldersSelectionFragment = new MusicFoldersSelectionFragment();
			
			Bundle bundle = new Bundle();
			bundle.putBoolean("com.aniruddhc.acemusic.player.WELCOME", true);
			mMusicFoldersSelectionFragment.setArguments(bundle);
		}
		
		return mMusicFoldersSelectionFragment;
	}

