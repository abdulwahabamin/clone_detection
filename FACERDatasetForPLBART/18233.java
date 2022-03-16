    @Override
    protected String doInBackground(String... params) {
    	
    	//Check if any music is playing and fade it out.
    	am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    	if (mApp.isServiceRunning()) {
    		
    		if (mApp.getService().isPlayingMusic()) {
    			targetVolume = 0;
    			currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);		
    			while(currentVolume > targetVolume) {
    			    am.setStreamVolume(AudioManager.STREAM_MUSIC, (currentVolume - stepDownValue), 0);
    			    currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
    			    
    			}
    			
    			mContext.stopService(new Intent(mContext, AudioPlaybackService.class));
    			
    		}
    		
    	}
    	
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
    	
    	String result = "GENERIC_EXCEPTION";
    	if (installed==false) {
    		//Can't do anything here anymore. Quit.
    		mApp.getSharedPreferences().edit().putBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false).commit();
    		return null;
    	} else {
    		//Grab music metadata from Google Play Music's public content mApp.
    		result = getMetadataFromGooglePlayMusicApp();
    	}
    	return result;
    }

