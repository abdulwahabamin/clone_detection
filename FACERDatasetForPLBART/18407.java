    /**
	 * Returns an integer array with EQ values for the specified song. 
	 * The final array index (10) indicates whether the specified song 
	 * has any saved EQ values (0 for false, 1 for true).
	 * 
	 * @param songId The id of the song to retrieve EQ values for.
     */
    public int[] getSongEQValues(String songId) {

        String condition = SONG_ID + "=" + "'" + songId + "'";
        String[] columnsToReturn = { _ID, EQ_50_HZ, EQ_130_HZ, EQ_320_HZ, 
        							 EQ_800_HZ, EQ_2000_HZ, EQ_5000_HZ, 
        							 EQ_12500_HZ, VIRTUALIZER, BASS_BOOST, REVERB };
        
        Cursor cursor = getDatabase().query(EQUALIZER_TABLE, columnsToReturn, condition, null, null, null, null);
        int[] eqValues = new int[11];
        
        if (cursor!=null && cursor.getCount()!=0)  {
        	cursor.moveToFirst();
			eqValues[0] = cursor.getInt(cursor.getColumnIndex(EQ_50_HZ));
			eqValues[1] = cursor.getInt(cursor.getColumnIndex(EQ_130_HZ));
			eqValues[2] = cursor.getInt(cursor.getColumnIndex(EQ_320_HZ));
			eqValues[3] = cursor.getInt(cursor.getColumnIndex(EQ_800_HZ));
			eqValues[4] = cursor.getInt(cursor.getColumnIndex(EQ_2000_HZ));
			eqValues[5] = cursor.getInt(cursor.getColumnIndex(EQ_5000_HZ));
			eqValues[6] = cursor.getInt(cursor.getColumnIndex(EQ_12500_HZ));
			eqValues[7] = cursor.getInt(cursor.getColumnIndex(VIRTUALIZER));
			eqValues[8] = cursor.getInt(cursor.getColumnIndex(BASS_BOOST));
			eqValues[9] = cursor.getInt(cursor.getColumnIndex(REVERB));
			eqValues[10] = 1; //The song id exists in the EQ table.
			
			cursor.close();
			
		} else {
			eqValues[0] = 16;
			eqValues[1] = 16;
			eqValues[2] = 16;
			eqValues[3] = 16;
			eqValues[4] = 16;
			eqValues[5] = 16;
			eqValues[6] = 16;
			eqValues[7] = 0;
			eqValues[8] = 0;
			eqValues[9] = 0;
			eqValues[10] = 0; //The song id doesn't exist in the EQ table.
			
		}
        
        return eqValues;
    }

