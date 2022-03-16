		@Override
		public void onPostExecute(String result) {
			super.onPostExecute(result);
			
			//Dismiss the progress dialog.
			pd.dismiss();
			
			//Initialize the tabs.
			//Attach tabs to the ActionBar.
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

			//Add the artists tab.
			String artistsLabel = getResources().getString(R.string.artists);
			Tab tab = actionBar.newTab();
			tab.setText(artistsLabel);
			TabListener<BlacklistedArtistsPickerFragment> artistsTabListener = new TabListener<BlacklistedArtistsPickerFragment>(mActivity, 
																						   				   artistsLabel, 
																						   				   BlacklistedArtistsPickerFragment.class);
			
			tab.setTabListener(artistsTabListener);
			actionBar.addTab(tab);

			//Add the albums tab.
			String albumsLabel = getResources().getString(R.string.albums);
			tab = actionBar.newTab();
			tab.setText(albumsLabel);
			TabListener<BlacklistedAlbumsPickerFragment> albumsTabListener = new TabListener<BlacklistedAlbumsPickerFragment>(mActivity,
																						  				albumsLabel, 
																						  				BlacklistedAlbumsPickerFragment.class);
			
			tab.setTabListener(albumsTabListener);
			actionBar.addTab(tab);
			
			//Add the songs tab.
			String songsLabel = getResources().getString(R.string.songs);
			tab = actionBar.newTab();
			tab.setText(songsLabel);
			TabListener<BlacklistedSongsPickerFragment> songsTabListener = new TabListener<BlacklistedSongsPickerFragment>(mActivity,
																									 songsLabel, 
																									 BlacklistedSongsPickerFragment.class);
			
			tab.setTabListener(songsTabListener);
			actionBar.addTab(tab);
			
		}

