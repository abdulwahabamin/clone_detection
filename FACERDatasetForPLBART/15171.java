	public static void updateEqualizerSettings(Context context){

        SharedPreferences mPreferences = context.getSharedPreferences(APOLLO_PREFERENCES, Context.MODE_WORLD_READABLE
                | Context.MODE_WORLD_WRITEABLE);

    	if(mBoost != null){
    		mBoost.setEnabled(mPreferences.getBoolean("simple_eq_boost_enable", false));
    		mBoost.setStrength ((short)(mPreferences.getInt("simple_eq_bboost",0)*10));
    	}
    	
    	if(mEqualizer != null){
	    	mEqualizer.setEnabled(mPreferences.getBoolean("simple_eq_equalizer_enable", false));
	    	short numBands = mEqualizer.getNumberOfBands()<=6?mEqualizer.getNumberOfBands():6;
	    	short r[] = mEqualizer.getBandLevelRange();
	        short min_level = r[0];
	        short max_level = r[1];
	    	for( int i = 0; i <= (numBands -1) ; i++ ){
	            int new_level = min_level + (max_level - min_level) * mPreferences.getInt("simple_eq_seekbars"+String.valueOf(i),100) / 100; 
	            mEqualizer.setBandLevel ((short)i, (short)new_level);
	    	}
    	}
    }

