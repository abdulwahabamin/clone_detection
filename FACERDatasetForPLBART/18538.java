	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		parentActivity = getActivity();
		dialogFragment = this;
		
		album = this.getArguments().getString("ALBUM");
		artist = this.getArguments().getString("ARTIST");
		callingActivity = this.getArguments().getString("CALLING_FRAGMENT");
		
		rootView = (View) parentActivity.getLayoutInflater().inflate(R.layout.fragment_caution_edit_albums, null);
		
		cautionText = (TextView) rootView.findViewById(R.id.caution_text);
        cautionText.setText(R.string.caution_albums_text);
		cautionText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		cautionText.setPaintFlags(cautionText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		sharedPreferences = getActivity().getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
		dontShowAgainText = (TextView) rootView.findViewById(R.id.dont_show_again_text);
		dontShowAgainText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		dontShowAgainText.setPaintFlags(dontShowAgainText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		dontShowAgainCheckbox = (CheckBox) rootView.findViewById(R.id.dont_show_again_checkbox);
		dontShowAgainCheckbox.setChecked(true);
		sharedPreferences.edit().putBoolean("SHOW_ALBUM_EDIT_CAUTION", false).commit();
		
		dontShowAgainCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
				
				if (isChecked==true) {
					sharedPreferences.edit().putBoolean("SHOW_ALBUM_EDIT_CAUTION", false).commit();
				} else {
					sharedPreferences.edit().putBoolean("SHOW_ALBUM_EDIT_CAUTION", true).commit();
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
				bundle.putString("EDIT_TYPE", "ALBUM");
				bundle.putString("ALBUM", album);
				bundle.putString("ARTIST", artist);
				bundle.putString("CALLING_FRAGMENT", callingActivity);
				ID3sAlbumEditorDialog dialog = new ID3sAlbumEditorDialog();
				dialog.setArguments(bundle);
				dialog.show(ft, "id3EditorDialog");
				
			}
        	
        });

        return builder.create();
    }

