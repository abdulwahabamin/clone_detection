	public void setIsEqualizerEnabled(boolean isEnabled) {
		getSharedPreferences().edit().putBoolean("EQUALIZER_ENABLED", isEnabled).commit();
		
		//Reload the EQ settings.
		if (isServiceRunning()) {
			try {
				getService().getEqualizerHelper().releaseEQObjects();
				getService().initAudioFX();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

