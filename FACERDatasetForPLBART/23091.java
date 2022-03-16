	@Override
	public void onBackPressed() {
		// If the current fragment is the list of albums we stop the service
		// and close the activity
		if (currentFragment == FRAGMENT_ALBUMS) {
			// Close music player when back button is pressed if music is
			// paused.
			if (!playQueue.isPlaying()) {
				Intent intent = new Intent(this, MusicService.class);
				stopService(intent);
				// Call the energy service to reset energy settings to the
				// initial ones before closing
				if (AppState.isEnergyStateSaved() && AppState.isEnergyModeEabled()) {
					Intent intentEnergyService = new Intent(getApplicationContext(), EnergyService.class);
					intentEnergyService.setAction(EnergyService.ACTION_SET_ENERGY_MODE);
					intentEnergyService.putExtra(EnergyService.EXTRA_ENERGY_MODE, initialEnergySettings);
					startService(intentEnergyService);
				}
				AppState.reset();
			}
			super.onBackPressed();// Close the activity
		} else {
			// If not, back to the list of albums
			addAlbumFragment();
		}
	}

