	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	//Result Code 45 = UserRecoverableAuthenticationException from GooglePlayMusicAuthenticationDialog.
    	if (requestCode==45) {
    		
    		final Intent finalData = data;
    		final int finalResultCode = resultCode;
    		
    		runOnUiThread(new Runnable() {

				@Override
				public void run() {
					//An unknown error occurred.
		            if (finalData==null) {
						Toast.makeText(mContext, R.string.unknown_error_google_music, Toast.LENGTH_LONG).show();
		                return;
		            }
		            
		            //The user handled the exception properly.
		            if (finalResultCode==RESULT_OK) {
		            	
		            	mApp.getSharedPreferences().edit().putBoolean("GOOGLE_PLAY_MUSIC_ENABLED", true).commit();
		            	mApp.getSharedPreferences().edit().putString("GOOGLE_PLAY_MUSIC_ACCOUNT", mAccountName).commit();

				        return;
		            }
		            
		            if (finalResultCode==RESULT_CANCELED) {
		            	finish();
		            }
		            
		            Toast.makeText(mContext, R.string.unknown_error_google_music, Toast.LENGTH_LONG).show();
				}
    			
    		});
    		
    	} else if (resultCode==10001) {
    		
    	}
    	
    }

