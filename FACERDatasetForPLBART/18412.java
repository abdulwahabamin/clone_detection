    /**
     * This method returns the specified eq preset.
     */
    public int[] getPresetEQValues(String presetName) {
    	
        String condition = PRESET_NAME + "=" + "'" + presetName.replace("'", "''") + "'";
        String[] columnsToReturn = { _ID, EQ_50_HZ, EQ_130_HZ, EQ_320_HZ, 
        							 EQ_800_HZ, EQ_2000_HZ, EQ_5000_HZ, 
        							 EQ_12500_HZ, VIRTUALIZER, BASS_BOOST, REVERB };
        
        Cursor cursor = getDatabase().query(EQUALIZER_PRESETS_TABLE, columnsToReturn, condition, null, null, null, null);
        int[] eqValues = new int[10];
        
        if (cursor!=null && cursor.getCount()!=0)  {
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
			
			cursor.close();
			
		} else {
			eqValues[0] = 16;
			eqValues[1] = 16;
			eqValues[2] = 16;
			eqValues[3] = 16;
			eqValues[4] = 16;
			eqValues[5] = 16;
			eqValues[6] = 16;
			eqValues[7] = 16;
			eqValues[8] = 16;
			eqValues[9] = 16;
			
		}
        
        return eqValues;
    }

