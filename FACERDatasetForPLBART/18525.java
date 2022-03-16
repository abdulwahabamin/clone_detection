	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		mApp = (Common) getActivity().getApplicationContext();
		mEqualizerFragment = (EqualizerActivity) getActivity();
		dialog = this;
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        dialogView = getActivity().getLayoutInflater().inflate(R.layout.add_new_equalizer_preset_dialog_layout, null);
        
        newPresetNameField = (EditText) dialogView.findViewById(R.id.new_preset_name_text_field);
        newPresetNameField.setTypeface(TypefaceHelper.getTypeface(getActivity(), "Roboto-Light"));
        newPresetNameField.setPaintFlags(newPresetNameField.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        
        //Set the dialog title.
        builder.setTitle(R.string.new_eq_preset);
        builder.setView(dialogView);
        builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialog.dismiss();
				
			}
        	
        });
        
        builder.setPositiveButton(R.string.done, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				//Get the preset name from the text field.
				String presetName = newPresetNameField.getText().toString();
				
				//Add the preset and it's values to the DB.
				mApp.getDBAccessHelper().addNewEQPreset(presetName, 
									  					mEqualizerFragment.getFiftyHertzLevel(), 
									  					mEqualizerFragment.getOneThirtyHertzLevel(), 
									  					mEqualizerFragment.getThreeTwentyHertzLevel(), 
									  					mEqualizerFragment.getEightHundredHertzLevel(), 
									  					mEqualizerFragment.getTwoKilohertzLevel(), 
									  					mEqualizerFragment.getFiveKilohertzLevel(), 
									  					mEqualizerFragment.getTwelvePointFiveKilohertzLevel(), 
									  					(short) mEqualizerFragment.getVirtualizerSeekBar().getProgress(), 
									  					(short) mEqualizerFragment.getBassBoostSeekBar().getProgress(), 
									  					(short) mEqualizerFragment.getReverbSpinner().getSelectedItemPosition());
				
				Toast.makeText(getActivity(), R.string.preset_saved, Toast.LENGTH_SHORT).show();
				dialog.dismiss();
			}
        	
        });

        return builder.create();
    }

