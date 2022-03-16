	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

		parentActivity = getActivity();
		
		final SharedPreferences sharedPreferences = parentActivity.
											  getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        //Check which style is currently selected and set the appropriate flag.
        if (sharedPreferences.getString("COVER_ART_STYLE", "CARD_STYLE").equals("CARD_STYLE")) {
        	selectedThemeIndex = 0;
        } else {
        	selectedThemeIndex = 1;
        }

        //Set the dialog title.
        builder.setTitle(R.string.cover_art_style);
        builder.setSingleChoiceItems(R.array.cover_art_style_choices, selectedThemeIndex, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				if (which==0) {
					sharedPreferences.edit().putString("COVER_ART_STYLE", "CARD_STYLE").commit();

				} else if (which==1) {
					sharedPreferences.edit().putString("COVER_ART_STYLE", "FILL_SCREEN").commit();

				}
				
				dialog.dismiss();
				getActivity().finish();
				
			}
        	
        });

        return builder.create();
    }

