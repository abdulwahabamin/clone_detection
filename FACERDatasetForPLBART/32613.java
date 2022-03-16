        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_updates);

            SensorManager senSensorManager  = (SensorManager) getActivity()
                    .getSystemService(Context.SENSOR_SERVICE);
            Sensor senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            boolean deviceHasAccelerometer = senSensorManager.registerListener(
                    sensorListener,
                    senAccelerometer,
                    SensorManager.SENSOR_DELAY_FASTEST);
            senSensorManager.unregisterListener(sensorListener);

            Preference updateWidgetUpdatePref = findPreference(Constants.KEY_PREF_LOCATION_AUTO_UPDATE_PERIOD);
            ListPreference updateListPref = (ListPreference) updateWidgetUpdatePref;
            int accIndex = updateListPref.findIndexOfValue("0");

            if (!deviceHasAccelerometer) {
                CharSequence[] entries = updateListPref.getEntries();
                CharSequence[] newEntries = new CharSequence[entries.length - 1];
                int i = 0;
                int j = 0;
                for (CharSequence entry : entries) {
                    if (i != accIndex) {
                        newEntries[j] = entries[i];
                        j++;
                    }
                    i++;
                }
                updateListPref.setEntries(newEntries);
                if (updateListPref.getValue() == null) {
                    updateListPref.setValueIndex(updateListPref.findIndexOfValue("60") - 1);
                }
            } else if (updateListPref.getValue() == null) {
                updateListPref.setValueIndex(accIndex);
            }
            LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getActivity());
            List<Location> availableLocations = locationsDbHelper.getAllRows();
            boolean oneNoautoLocationAvailable = false;
            for (Location location: availableLocations) {
                if (location.getOrderId() != 0) {
                    oneNoautoLocationAvailable = true;
                    break;
                }
            }
            if (!oneNoautoLocationAvailable) {
                ListPreference locationPreference = (ListPreference) findPreference("location_update_period_pref_key");
                locationPreference.setEnabled(false);
            }

            ListPreference locationAutoPreference = (ListPreference) findPreference("location_auto_update_period_pref_key");
            locationAutoPreference.setEnabled(locationsDbHelper.getLocationByOrderId(0).isEnabled());
        }

