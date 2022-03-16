	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_energyMode:
			// Display an alert dialog to select the energyMode
			final String[] listEnergyModes = MainActivity.this.getResources().getStringArray(R.array.energymode_array);
			final String[] listEnergyModesValues = MainActivity.this.getResources().getStringArray(
					R.array.energymode_array_values);

			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle(getResources().getString(R.string.energyMode_title));
			builder.setItems(listEnergyModes, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					// Save the selected energy mode ID in the SharedPrefrences
					// object.
					short energyModeID = new Short(listEnergyModesValues[item]);
					SharedPreferences.Editor editor = preferences.edit();
					editor.putInt(PREF_KEY_ENERGYMODE, energyModeID);
					editor.commit();
					// Start the energy service to enable the selected energy
					// Mode
					EnergyMode em = buildEnergyMode(energyModeID);
					Intent intentEnergyService = new Intent(getApplicationContext(), EnergyService.class);
					intentEnergyService.setAction(EnergyService.ACTION_SET_ENERGY_MODE);
					intentEnergyService.putExtra(EnergyService.EXTRA_ENERGY_MODE, em);
					startService(intentEnergyService);
				}
			});
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

