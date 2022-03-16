	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {		
        Editor ed = mPreferences.edit();
		if (seekBar == bBoost)
        {
            ed.putInt("simple_eq_bboost", progress);
        }
		else{
			for( int i = 0; i <= 5 ; i++ ){
				if(SeekBars[i]==seekBar){
		            ed.putInt("simple_eq_seekbars"+String.valueOf(i), progress);				
				}
			}
		}
        SharedPreferencesCompat.apply(ed);
        MusicUtils.updateEqualizerSettings(getApplicationContext());
	}

