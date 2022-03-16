	/**
	 * Builds the "Load Preset" dialog. Does not call the show() method, so this 
	 * should be done manually after calling this method.
	 * 
	 * @return A fully built AlertDialog reference.
	 */
	private AlertDialog buildLoadPresetDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Get a cursor with the list of EQ presets.
        final Cursor cursor = mApp.getDBAccessHelper().getAllEQPresets();
        
        //Set the dialog title.
        builder.setTitle(R.string.load_preset);
        builder.setCursor(cursor, new DialogInterface.OnClickListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void onClick(DialogInterface dialog, int which) {
				cursor.moveToPosition(which);
				
				//Close the dialog.
				dialog.dismiss();
				
				//Pass on the equalizer values to the appropriate fragment.
				fiftyHertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_50_HZ));
				oneThirtyHertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_130_HZ));
				threeTwentyHertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_320_HZ));
				eightHundredHertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_800_HZ));
				twoKilohertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_2000_HZ));
				fiveKilohertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_5000_HZ));
				twelvePointFiveKilohertzLevel = cursor.getInt(cursor.getColumnIndex(DBAccessHelper.EQ_12500_HZ));
				virtualizerLevel = cursor.getShort(cursor.getColumnIndex(DBAccessHelper.VIRTUALIZER));
				bassBoostLevel = cursor.getShort(cursor.getColumnIndex(DBAccessHelper.BASS_BOOST));
				reverbSetting = cursor.getShort(cursor.getColumnIndex(DBAccessHelper.REVERB));
				
				//Save the new equalizer settings to the DB.
				@SuppressWarnings({ "rawtypes" })
				AsyncTask task = new AsyncTask() {

					@Override
					protected Object doInBackground(Object... arg0) {
						setEQValuesForSong(mApp.getService().getCurrentSong().getId());
						return null;
					}
					
					@Override
					public void onPostExecute(Object result) {
						super.onPostExecute(result);
						
						//Reinitialize the UI elements to apply the new equalizer settings.
						new AsyncInitSlidersTask().execute();
					}
					
				};
				task.execute();

				if (cursor!=null)
					cursor.close();
				
			}
			
		}, DBAccessHelper.PRESET_NAME);

        return builder.create();
        
	}

