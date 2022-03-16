		@Override
		public void onPageSelected(int page) {

			/* If the user swiped away from the music folders 
			 * selection fragment, save the music folders to 
			 * the database.
			 */
			if (page==0 || page==2) {
				new AsyncSaveMusicFoldersTask(mContext.getApplicationContext(), 
											  mMusicFoldersFragment.getMusicFoldersSelectionFragment()
											  				       .getMusicFoldersHashMap())
											 .execute();
			}
			
			/* If the user scrolls away from the Google Play Music page and 
			 * they have selected an account, check if the default Google Play 
			 * Music app is installed. */
			if (page==3) {
				
				if (mApp.getSharedPreferences().getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {
					//Check if the Google Play Music app is installed.
			    	PackageManager pm = mContext.getPackageManager();
			    	boolean installed = false;
			    	try {
						pm.getPackageInfo("com.google.android.music", PackageManager.GET_ACTIVITIES);
						installed = true;
					} catch (NameNotFoundException e1) {
						//The app isn't installed.
						installed = false;
					}

			    	if (installed==false) {
			    		//Prompt the user to install Google Play Music.
			    		promptUserInstallGooglePlayMusic();
			    	}
				
				}
		    	
			}
			
			//Launch the scanning AsyncTask.
			if (page==5)
                showBuildingLibraryProgress();
			
		}

