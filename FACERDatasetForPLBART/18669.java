	/**
	 * Builds the "Save Preset" dialog. Does not call the show() method, so you 
	 * should do this manually when calling this method.
	 * 
	 * @return A fully built AlertDialog reference.
	 */
	private AlertDialog buildSavePresetDialog() {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.add_new_equalizer_preset_dialog_layout, null);
        
        final EditText newPresetNameField = (EditText) dialogView.findViewById(R.id.new_preset_name_text_field);
        newPresetNameField.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Light"));
        newPresetNameField.setPaintFlags(newPresetNameField.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        //Set the dialog title.
        builder.setTitle(R.string.save_preset);
        builder.setView(dialogView);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        builder.setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				//Get the preset name from the text field.
				String presetName = newPresetNameField.getText().toString();
				
				//Add the preset and it's values to the DB.
				mApp.getDBAccessHelper().addNewEQPreset(presetName, 
									  				    fiftyHertzLevel, 
									  				    oneThirtyHertzLevel, 
									  				    threeTwentyHertzLevel, 
									  				    eightHundredHertzLevel, 
									  				    twoKilohertzLevel, 
									  				    fiveKilohertzLevel, 
									  				    twelvePointFiveKilohertzLevel, 
									  				    (short) virtualizerSeekBar.getProgress(), 
									  				    (short) bassBoostSeekBar.getProgress(), 
									  				    (short) reverbSpinner.getSelectedItemPosition());
				
				Toast.makeText(mContext, R.string.preset_saved, Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
        	
        });

        return builder.create();
        
	}

