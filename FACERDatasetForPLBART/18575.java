	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		mContext = getActivity();
		parentActivity = getActivity();
		dialogFragment = this;
		
		//Get the artist name.
		ARTIST = getArguments().getString("ARTIST");
		
		rootView = (View) parentActivity.getLayoutInflater().inflate(R.layout.fragment_edit_id3_artist_album_dialog, null);
		
		titleText = (TextView) rootView.findViewById(R.id.edit_title_text);
		artistText = (TextView) rootView.findViewById(R.id.edit_artist_text);
		albumText = (TextView) rootView.findViewById(R.id.edit_album_text);
		albumArtistText = (TextView) rootView.findViewById(R.id.edit_album_artist_text);
		genreText = (TextView) rootView.findViewById(R.id.edit_genre_text);
		producerText = (TextView) rootView.findViewById(R.id.edit_producer_text);
		yearText = (TextView) rootView.findViewById(R.id.edit_year_text);
		trackText = (TextView) rootView.findViewById(R.id.edit_track_text);
		ofText = (TextView) rootView.findViewById(R.id.text_of);
		commentsText = (TextView) rootView.findViewById(R.id.edit_comment_text);
		
		titleEditText = (EditText) rootView.findViewById(R.id.edit_title_field);
		artistEditText = (EditText) rootView.findViewById(R.id.edit_artist_field);
		albumEditText = (EditText) rootView.findViewById(R.id.edit_album_field);
		albumArtistEditText = (EditText) rootView.findViewById(R.id.edit_album_artist_field);
		genreEditText = (EditText) rootView.findViewById(R.id.edit_genre_field);
		producerEditText = (EditText) rootView.findViewById(R.id.edit_producer_field);
		yearEditText = (EditText) rootView.findViewById(R.id.edit_year_field);
		trackEditText = (EditText) rootView.findViewById(R.id.edit_track_field);
		trackTotalEditText = (EditText) rootView.findViewById(R.id.edit_track_total_field);
		commentsEditText = (EditText) rootView.findViewById(R.id.edit_comment_field);
		
		titleCheckbox = (CheckBox) rootView.findViewById(R.id.title_checkbox);
		artistCheckbox = (CheckBox) rootView.findViewById(R.id.artist_checkbox);
		albumCheckbox = (CheckBox) rootView.findViewById(R.id.album_checkbox);
		albumArtistCheckbox = (CheckBox) rootView.findViewById(R.id.album_artist_checkbox);
		genreCheckbox = (CheckBox) rootView.findViewById(R.id.genre_checkbox);
		producerCheckbox = (CheckBox) rootView.findViewById(R.id.producer_checkbox);
		yearCheckbox = (CheckBox) rootView.findViewById(R.id.year_checkbox);
		trackCheckbox = (CheckBox) rootView.findViewById(R.id.track_checkbox);
		commentCheckbox = (CheckBox) rootView.findViewById(R.id.comment_checkbox);
		
		titleText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		artistText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		albumText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		albumArtistText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		genreText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		producerText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		yearText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		trackText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		ofText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		commentsText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		
		titleText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		artistText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		albumText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		albumArtistText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		genreText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		producerText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		yearText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		trackText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		ofText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		commentsText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
		
		titleEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		artistEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		albumEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		albumArtistEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		genreEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		producerEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		yearEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		trackEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		trackTotalEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		commentsEditText.setTypeface(TypefaceHelper.getTypeface(parentActivity, "RobotoCondensed-Light"));
		
		titleEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		artistEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		albumEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		albumArtistEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		genreEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		producerEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		yearEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		trackEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		trackTotalEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		commentsEditText.setPaintFlags(titleText.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		//Keep all the fields locked by default.
		titleCheckbox.setChecked(false);
		artistCheckbox.setChecked(false);
		albumCheckbox.setChecked(false);
		albumArtistCheckbox.setChecked(false);
		genreCheckbox.setChecked(false);
		producerCheckbox.setChecked(false);
		yearCheckbox.setChecked(false);
		trackCheckbox.setChecked(false);
		commentCheckbox.setChecked(false);
		
		//Disable all EditTexts by default.
		titleEditText.setEnabled(false);
		artistEditText.setEnabled(false);
		albumEditText.setEnabled(false);
		albumArtistEditText.setEnabled(false);
		genreEditText.setEnabled(false);
		producerEditText.setEnabled(false);
		yearEditText.setEnabled(false);
		trackEditText.setEnabled(false);
		commentsEditText.setEnabled(false);
		
		//Register click registers on each checkbox.
		titleCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {

				if (checked==true) {
					titleEdited = true;
					titleEditText.setEnabled(true);
				} else {
					titleEdited = false;
					titleEditText.setEnabled(false);
				}
				
			}
			
		});
		
		artistCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					artistEdited = true;
					artistEditText.setEnabled(true);;
				} else {
					artistEdited = false;
					artistEditText.setEnabled(false);
				}
				
			}
			
		});
		
		albumArtistCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					albumEdited = true;
					albumEditText.setEnabled(true);;
				} else {
					albumEdited = false;
					albumEditText.setEnabled(false);
				}
				
			}
			
		});
		
		albumCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					albumArtistEdited = true;
					albumArtistEditText.setEnabled(true);;
				} else {
					albumArtistEdited = false;
					albumArtistEditText.setEnabled(false);
				}
				
			}
			
		});
		
		genreCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					genreEdited = true;
					genreEditText.setEnabled(true);;
				} else {
					genreEdited = false;
					genreEditText.setEnabled(false);
				}
				
			}
			
		});
		
		producerCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					producerEdited = true;
					producerEditText.setEnabled(true);;
				} else {
					producerEdited = false;
					producerEditText.setEnabled(false);
				}
				
			}
			
		});
		
		yearCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					yearEdited = true;
					yearEditText.setEnabled(true);;
				} else {
					yearEdited = false;
					yearEditText.setEnabled(false);
				}
				
			}
			
		});
		
		trackCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					trackEdited = true;
					trackEditText.setEnabled(true);;
				} else {
					trackEdited = false;
					trackEditText.setEnabled(false);
				}
				
			}
			
		});
		
		commentCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton checkbox, boolean checked) {
				
				if (checked==true) {
					commentEdited = true;
					commentsEditText.setEnabled(true);;
				} else {
					commentEdited = false;
					commentsEditText.setEnabled(false);
				}
				
			}
			
		});

		if (ARTIST!=null) {
			songURIsList = getAllSongsByArtist(ARTIST);
			
			//Populate the ArrayLists with the song tags.
			try {
				getSongTags(songURIsList);
			} catch (CannotReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ReadOnlyFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidAudioFrameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Now check if any of the ArrayLists contain the same exact elements.
			boolean titlesSame = checkIfAllElementsEqual(titlesList);
			boolean artistsSame = checkIfAllElementsEqual(artistsList);
			boolean albumsSame = checkIfAllElementsEqual(albumsList);
			boolean albumArtistsSame = checkIfAllElementsEqual(albumArtistsList);
			boolean genresSame = checkIfAllElementsEqual(genresList);
			boolean producersSame = checkIfAllElementsEqual(producersList);
			boolean yearsSame = checkIfAllElementsEqual(yearsList);
			boolean tracksSame = checkIfAllElementsEqual(trackNumbersList);
			boolean totalTracksSame = checkIfAllElementsEqual(totalTracksList);
			boolean commentsSame = checkIfAllElementsEqual(commentsList);
			
			//Populate the EditTexts.
			setEditorFields(titlesSame, titlesList, titleEditText);
			setEditorFields(artistsSame, artistsList, artistEditText);
			setEditorFields(albumsSame, albumsList, albumEditText);
			setEditorFields(albumArtistsSame, albumArtistsList, albumArtistEditText);
			setEditorFields(genresSame, genresList, genreEditText);
			setEditorFields(producersSame, producersList, producerEditText);
			setEditorFields(yearsSame, yearsList, yearEditText);
			setEditorFields(tracksSame, trackNumbersList, trackEditText);
			setEditorFields(totalTracksSame, totalTracksList, trackTotalEditText);
			setEditorFields(commentsSame, commentsList, commentsEditText);
			
		}
		
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog title.
        builder.setTitle(R.string.edit_tags);
        builder.setView(rootView);
        builder.setPositiveButton(R.string.save, new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				dialogFragment.dismiss();
				AsyncSaveArtistTagsTask asyncSaveArtistTagsTask = new AsyncSaveArtistTagsTask(getActivity(), getActivity());
				asyncSaveArtistTagsTask.execute();
        	
			}
	        
        });
        
        builder.setNegativeButton(R.string.cancel, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				
			}
        	
        });

        return builder.create();
			
	}

