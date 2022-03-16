	@Override
	protected void onHandleIntent(Intent intent) {
		// ACTION_SET_ENERGY_MODE: The service receives a EnergyMode object
		// inside the intent and applies these settings to the system.
		if (intent.getAction().equals(ACTION_SET_ENERGY_MODE)) {
			EnergyMode energyMode = (EnergyMode) intent.getExtras().getSerializable(EXTRA_ENERGY_MODE);
			if (energyMode != null) {
				if (!energyMode.isAirPlaneModeOn()) {
					if (!energyMode.isBluetoothOn())
						disableBluetooth();
					setWifiEnabled(energyMode.isWifiOn());
				}
				setAutoSynEnabled(energyMode.isAutoSyncOn());
				setAirplaneModeOn(energyMode.isAirPlaneModeOn());
				int maxFreq = energyMode.getCPUFrequency();
				if (maxFreq != EnergyMode.NO_FREQUENCY)
					setCpuMaxFrequency(maxFreq);
				String governor = energyMode.getGovernor();
				if (governor != null)
					setCpuGovernor(governor);

			} else {
				Log.e(getClass().getName(), "There is not energy mode object inside the Intent object");
			}
			// Notify the main activity
			Intent intentEnergyModeSet = new Intent(ENERGY_MODE_SET);
			sendBroadcast(intentEnergyModeSet);
			// ACTION_GET_ENERGY_STATE: The service reads the energy settings
			// from the system and saves them in the IntialEnergySettings object
		} else if (intent.getAction().equals(ACTION_GET_ENERGY_STATE)) {
			InitialEnergySettings iniEnergySettings = InitialEnergySettings.getInstance();
			iniEnergySettings.setAirPlaneModeOn(isAirPlaneModeOn());
			iniEnergySettings.setAutoSyncOn(isAutoSyncOn());
			iniEnergySettings.setBluetoothOn(isBluetoothOn());
			iniEnergySettings.setWifiOn(isWifiOn());
			iniEnergySettings.setGPSOn(isGPSOn());
			iniEnergySettings.setCPUFrequency(getMaxCPUFrequency());
			iniEnergySettings.setGovernor(getCPUGovernor());
			// Notify the main activity
			Intent intentEnergyStateGet = new Intent(ENERGY_STATE_GET);
			sendBroadcast(intentEnergyStateGet);
			Log.d(getClass().getName(), "Initial energy settings saved: \n" + iniEnergySettings.toString());
		}
		stopSelf();// STOP itself
	}

