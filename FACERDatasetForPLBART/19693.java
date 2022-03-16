	/**
	 * Toggles the equalizer.
	 */
	public void toggleEqualizer() {
		if (isEqualizerEnabled()) {
			getSharedPreferences().edit().putBoolean("EQUALIZER_ENABLED", true).commit();

			if (isServiceRunning()) {
				try {
					getService().getEqualizerHelper().getEqualizer().setEnabled(false);
					getService().getEqualizerHelper().getEqualizer2().setEnabled(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} else {
			getSharedPreferences().edit().putBoolean("EQUALIZER_ENABLED", true).commit();

			if (isServiceRunning()) {
				try {
					getService().getEqualizerHelper().getEqualizer().setEnabled(true);
					getService().getEqualizerHelper().getEqualizer2().setEnabled(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

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

