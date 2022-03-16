    @Override
    protected void onPostExecute(Void arg0) {
    	
    	/* Now that we have a list of audio files within the folder, pass them
    	 * on to NowPlayingActivity (which will assemble the files into a cursor for the service. */
		
    	//Check if the list is empty. If it is, show a Toast message to the user.
    	if (audioFilePathsInFolder.size() > 0) {
    		
    		//Check if the audio file has a title. If not, use the file name.
    		String title = "";
    		if (metadata.get(0)==null) {
    			title = audioFilePathsInFolder.get(0);
    		} else {
    			title = (String) metadata.get(0);
    		}
    		
    		Intent intent = new Intent(mContext, NowPlayingActivity.class);
    		intent.putExtra("DURATION", (String) metadata.get(3));
    		intent.putExtra("SONG_NAME", title);
    		intent.putExtra("NUMBER_SONGS", 1);
    		
    		if (metadata.get(1)==null) {
    			intent.putExtra("ARTIST", "Unknown Artist");
    		} else {
    			intent.putExtra("ARTIST", (String) metadata.get(1));
    		}
    		
    		if (metadata.get(2)==null) {
    			intent.putExtra("ALBUM", "Unknown Album");
    		} else {
    			intent.putExtra("ALBUM", (String) metadata.get(2));
    		}
    		
    		if (metadata.get(3)==null) {
    			intent.putExtra("SELECTED_SONG_DURATION", 0);
    		} else {
    			intent.putExtra("SELECTED_SONG_DURATION", (String) metadata.get(3));
    		}
    		
    		intent.putExtra("DATA_URI", audioFilePathsInFolder.get(0));
    		
    		if (metadata.get(4)==null) {
    			intent.putExtra("EMBEDDED_ART", (byte[]) null);
    		} else {
    			intent.putExtra("EMBEDDED_ART", (byte[]) metadata.get(4));
    		}

    		intent.putExtra("NEW_PLAYLIST", true);
    		intent.putExtra("CALLED_FROM_FOOTER", false);
    		intent.putExtra("CALLED_FROM_FOLDERS", true);
    		intent.putExtra("CALLING_FRAGMENT", "FOLDERS_FRAGMENT");
    		
    		//We're dealing with the first audio file in the list, so just use zero for SONG_SELECTED_INDEX.
    		intent.putExtra("SONG_SELECTED_INDEX", 0);
    		
    		//Pass on the list of file paths to NowPlayingActivity (which will assemble them into a cursor).
    		intent.putStringArrayListExtra("FOLDER_AUDIO_FILE_PATHS", audioFilePathsInFolder);
    		
    		pd.dismiss();
    		
    		Log.e("DEBUG", ">>>>>>>>>>>>TIME TO START THE ACTIVITY");
    		mContext.startActivity(intent);
    		mContext.overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    		
    	} else {
    		pd.dismiss();
    		Toast.makeText(mContext, R.string.no_audio_files_found, Toast.LENGTH_LONG).show();
    	}
    	
    	mContext = null;
		
	}

