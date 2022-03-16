    public void initEqualizerValues(){
    	bBoost.setProgress(mPreferences.getInt("simple_eq_bboost",0));
    	bBoostEnable.setChecked(mPreferences.getBoolean("simple_eq_boost_enable", false));
    	eQEnable.setChecked(mPreferences.getBoolean("simple_eq_equalizer_enable", false));
        int[] freqs = MusicUtils.getEqualizerFrequencies();
		for( int i = 0; i <= 5 ; i++ ){
			SeekBars[i].setProgress(mPreferences.getInt("simple_eq_seekbars"+String.valueOf(i),100));
			String freq = "";
			if( i <= ( freqs.length-1 ) ){
			    if (freqs[i] < 1000000)
			    	freq= "" + (freqs[i] / 1000) + "Hz";
			    else
			    	freq= "" + (freqs[i] / 1000000) + "kHz";	
			}
			else{
				freq = "0Hz";
			}
		    SeekBarLabels[i].setText(freq);		  
		}
    }

