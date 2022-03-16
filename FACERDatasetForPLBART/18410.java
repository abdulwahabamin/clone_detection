    /**
     * Updates the equalizer/audio effects for the specified song.
     */
    public void updateSongEQValues(String songId, 
							 	   int fiftyHertz, 
							 	   int oneThirtyHertz, 
							 	   int threeTwentyHertz, 
							 	   int eightHundredHertz, 
							 	   int twoKilohertz, 
							 	   int fiveKilohertz, 
							 	   int twelvePointFiveKilohertz, 
							 	   int virtualizer,
							 	   int bassBoost, 
							 	   int reverb) {
     
        ContentValues values = new ContentValues();
        values.put(EQ_50_HZ, fiftyHertz);
        values.put(EQ_130_HZ, threeTwentyHertz);
        values.put(EQ_320_HZ, threeTwentyHertz);
        values.put(EQ_800_HZ, eightHundredHertz);
        values.put(EQ_2000_HZ, twoKilohertz);
        values.put(EQ_5000_HZ, fiveKilohertz);
        values.put(EQ_12500_HZ, twelvePointFiveKilohertz);
		values.put(VIRTUALIZER, virtualizer);
		values.put(BASS_BOOST, bassBoost);
		values.put(REVERB, reverb);
     
        String condition = SONG_ID + " = " + "'" + songId + "'" ;
        getDatabase().update(EQUALIZER_TABLE, values, condition, null);
        
    }

