	private void updateResumePosition(){
		long currentTime = System.currentTimeMillis();
		if(currentTime - 10000 > lastResumeUpdateTime){
			if(mp != null && songFile != null && mp.isPlaying()){
				int pos = mp.getCurrentPosition();
				SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
				Log.i(TAG,
						"Preferences update success: "
								+ prefs.edit()
								.putString(songFile.getParentFile().getAbsolutePath(),songFile.getName() + "~" + pos)
								.commit());
			}
			lastResumeUpdateTime = currentTime;
		}
	}

