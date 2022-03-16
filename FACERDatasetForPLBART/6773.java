	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		if(key.equals("sortby")){
			changeListPreferenceSummaryToCurrentValue((ListPreference)findPreference(key));
		}
	}

