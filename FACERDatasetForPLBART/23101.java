	private EnergyMode buildEnergyMode(int energyModeId) {
		EnergyMode em = new EnergyMode();
		switch (energyModeId) {
		case 0:
			/*
			 * Building energy mode: Normal; only bluetooth off.
			 */
			em.setBluetoothOn(false);
			em.setAirPlaneModeOn(initialEnergySettings.isAirPlaneModeOn());
			em.setAutoSyncOn(initialEnergySettings.isAutoSyncOn());
			em.setBluetoothOn(initialEnergySettings.isBluetoothOn());
			em.setCPUFrequency(initialEnergySettings.getCPUFrequency());
			em.setGovernor(initialEnergySettings.getGovernor());
			break;
		case 2:
			/*
			 * Building energy mode: EcoPlus; Max cpu: 200Mhz CPU, governor:
			 * Conservative, Air plane mode ON (disable all connections), Auto
			 * sync off
			 */
			em.setAirPlaneModeOn(true);
			em.setAutoSyncOn(false);
			em.setCPUFrequency(400000);
			em.setGovernor("conservative");
			break;
		default:
			/*
			 * Building energy mode: Eco; Max cpu: 800Mhz CPU, governor:
			 * Conservative, Wifi Off, Bluetooth off, Auto sync off
			 */
			em.setWifiOn(false);
			em.setBluetoothOn(false);
			em.setAutoSyncOn(false);
			em.setCPUFrequency(800000);
			em.setGovernor("conservative");

		}
		return em;
	}

