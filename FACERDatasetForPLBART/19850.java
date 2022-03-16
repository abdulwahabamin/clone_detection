        @Override
        public Fragment getItem(int position) {
        	
        	//Assign the appropriate screen to the fragment object, based on which screen is displayed.
        	switch (position) {
        	case 0:
        		return new WelcomeFragment();
        	case 1:
        		mMusicFoldersFragment = new MusicFoldersFragment();
        		return mMusicFoldersFragment;
        	case 2:
        		return new AlbumArtFragment();
        	case 3:
        		return new GooglePlayMusicFragment();
        	case 4:
        		return new ReadyToScanFragment();
        	case 5:
        		mBuildingLibraryProgressFragment = new BuildingLibraryProgressFragment();
        		return mBuildingLibraryProgressFragment;
        	default:
        		return null;
        	}
        	
        }

