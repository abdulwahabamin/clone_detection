	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
    	
		if (mFirstRun) {
			pd.dismiss();
		}
    	
    	//Perform an action based on the operation's result code.
    	if (result.equals("GOOGLE_PLAY_SERVICES_AVAILABILITY_EXCEPTION")) {
    		Dialog d = GooglePlayServicesUtil.getErrorDialog(availabilityExceptionStatusCode,
					 mActivity,
					 REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
    		d.show();
    	
    	} else if (result.equals("USER_RECOVERABLE_AUTH_EXCEPTION")) {
    		//45 is an arbitrary value that identifies this activity's result.
    		LauncherActivity.mAccountName = mAccountName;
    		SettingsActivity____.mAccountName = mAccountName;
    		
    		if (mActivity!=null) {
    			mActivity.startActivityForResult(userRecoverableExceptionIntent, 45);
    		}
			
    	} else if (result.equals("GOOGLE_AUTH_EXCEPTION") || result.equals("GENERIC_EXCEPTION")) {
    		Toast.makeText(mContext, R.string.unknown_error_google_music, Toast.LENGTH_LONG).show();
    	} else if (result.equals("AUTHENTICATED")) {
    		if (mFirstRun) {
        		String text = mContext.getResources().getString(R.string.signed_in_as) + " " + mAccountName;
        		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    		} else if (mFirstRunFromSettings) {
    			//Start scanning the library to add GMusic songs.
    			String text = mContext.getResources().getString(R.string.signed_in_as) + " " + mAccountName;
        		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
        		
        		//Seting the "REBUILD_LIBRARY" flag to true will force MainActivity to rescan the folders.
				mApp.getSharedPreferences().edit().putBoolean("REBUILD_LIBRARY", true).commit();
				
				//Restart the app.
				final Intent i = mActivity.getBaseContext().getPackageManager().getLaunchIntentForPackage(mActivity.getBaseContext().getPackageName());
				
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				mActivity.finish();
				mActivity.startActivity(i);
    		}
    		mApp.getSharedPreferences().edit().putBoolean("GOOGLE_PLAY_MUSIC_ENABLED", true).commit();
    	} else {
    		Toast.makeText(mContext, R.string.unknown_error_google_music, Toast.LENGTH_LONG).show();
    	}
    	
	}

