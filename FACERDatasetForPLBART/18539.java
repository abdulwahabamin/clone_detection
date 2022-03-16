	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		parentActivity = getActivity();
		dialogFragment = this;
		
		EDIT_TYPE = this.getArguments().getString("EDIT_TYPE");
		ARTIST = this.getArguments().getString("ARTIST");
		
		rootView = (View) parentActivity.getLayoutInflater().inflate(R.layout.fragment_caution_edit_artists, null);
		
		cautionText = (TextView) rootView.findViewById(R.id.caution_text);
		cautionText.setText(R.string.caution_artists_text);
		cautionText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		cautionText.setPaintFlags(cautionText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		sharedPreferences = getActivity().getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		sharedPreferences.edit().putBoolean("SHOW_ARTIST_EDIT_CAUTION", false).commit();
		
		dontShowAgainText = (TextView) rootView.findViewById(R.id.dont_show_again_text);
		dontShowAgainText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		dontShowAgainText.setPaintFlags(dontShowAgainText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		dontShowAgainCheckbox = (CheckBox) rootView.findViewById(R.id.dont_show_again_checkbox);
		dontShowAgainCheckbox.setChecked(true);
		
		dontShowAgainCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				
				if (isChecked==true) {
					sharedPreferences.edit().putBoolean("SHOW_ARTIST_EDIT_CAUTION", false).commit();
				} else {
					sharedPreferences.edit().putBoolean("SHOW_ARTIST_EDIT_CAUTION", true).commit();
				}
				
			}
			
		});
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.caution);
        builder.setView(rootView);
        builder.setNegativeButton(R.string.no, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialogFragment.dismiss();
				
			}
        	
        });
        
        builder.setPositiveButton(R.string.yes, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialogFragment.dismiss();
				
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				Bundle bundle = new Bundle();
				bundle.putString("EDIT_TYPE", EDIT_TYPE);
				bundle.putString("ARTIST", ARTIST);
				ID3sArtistEditorDialog dialog = new ID3sArtistEditorDialog();
				dialog.setArguments(bundle);
				dialog.show(ft, "id3ArtistEditorDialog");
				
			}
        	
        });

        return builder.create();
    }

