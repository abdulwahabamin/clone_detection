	@Override
	public void onCheckedChanged(CompoundButton bView, boolean isChecked) {
        Editor ed = mPreferences.edit();
		if(bView ==  bBoostEnable){
            ed.putBoolean("simple_eq_boost_enable", isChecked);		
		}
		else if(bView == eQEnable){
            ed.putBoolean("simple_eq_equalizer_enable", isChecked);
		}
        SharedPreferencesCompat.apply(ed);
		MusicUtils.updateEqualizerSettings(getApplicationContext());
	}

