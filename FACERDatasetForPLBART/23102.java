		public void onReceive(android.content.Context context, Intent intent) {
			// Broadcast from music service. Current song and/or player status
			// have changed
			if (intent.getAction().equals(MusicService.MUSIC_UPDATE)) {
				boolean songChanged = intent.getBooleanExtra(MusicService.SONG_CHANGED, false);
				boolean playerStateChanged = intent.getBooleanExtra(MusicService.PLAYER_STATE_CHANGED, false);
				FragmentEcoPlayer fragmentButtons = (FragmentEcoPlayer) fragmentManager
						.findFragmentById(R.id.fragment_container_buttons);
				FragmentEcoPlayer fragmentList = (FragmentEcoPlayer) fragmentManager
						.findFragmentById(R.id.fragment_container_lists);
				if (songChanged) {
					if (fragmentButtons != null)
						fragmentButtons.onSongChanged();
					if (fragmentList != null)
						fragmentList.onSongChanged();
				}
				if (playerStateChanged) {
					if (fragmentButtons != null)
						fragmentButtons.onMusicPlayerStateChanged();
					if (fragmentList != null)
						fragmentList.onMusicPlayerStateChanged();
				}
				// Broadcast from energy service. The process of enabling an
				// energy mode has finished
			} else if (intent.getAction().equals(EnergyService.ENERGY_MODE_SET)) {
				AppState.setEnergyModeEabled(true);
				final String[] listEnergyModes = MainActivity.this.getResources().getStringArray(
						R.array.energymode_array);
				// Get the name of the energy mode currently selected
				String energyModeName = listEnergyModes[preferences.getInt(PREF_KEY_ENERGYMODE, 1)];
				Toast.makeText(getApplicationContext(),
						energyModeName + " " + getResources().getString(R.string.energyMode_enabled), Toast.LENGTH_LONG)
						.show();
				// Broadcast from energy service. THe process of retrieving and
				// saving the initial energy settings has finished.
			} else if (intent.getAction().equals(EnergyService.ENERGY_STATE_GET)) {
				AppState.setEnergyStateSaved(true);
				// Show GPS message if it's enabled
				if (initialEnergySettings.isGPSOn())
					showAlertMessageGps();
				// Call the energy service to enable the selected energy mode
				EnergyMode em = buildEnergyMode(preferences.getInt(PREF_KEY_ENERGYMODE, 1));
				Intent intentEnergyService = new Intent(getApplicationContext(), EnergyService.class);
				intentEnergyService.setAction(EnergyService.ACTION_SET_ENERGY_MODE);
				intentEnergyService.putExtra(EnergyService.EXTRA_ENERGY_MODE, em);
				startService(intentEnergyService);
			}
		}

