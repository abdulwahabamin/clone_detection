	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mApp = (Common) getActivity().getApplicationContext();
		View rootView = inflater.inflate(R.layout.fragment_songs_music_library_editor, null);
		cursor = mApp.getDBAccessHelper().getAllSongs();
		
		listView = (ListView) rootView.findViewById(R.id.musicLibraryEditorSongsListView);
		listView.setFastScrollEnabled(true);
		listView.setAdapter(new PlaylistEditorSongsMultiselectAdapter(getActivity(), cursor));

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int which, long dbID) {
				CheckBox checkbox = (CheckBox) view.findViewById(R.id.songCheckboxMusicLibraryEditor);
				checkbox.performClick();
				
				/* Since we've performed a software-click (checkbox.performClick()), all we have 
				 * to do now is determine the *new* state of the checkbox. If the checkbox is checked, 
				 * that means that the user tapped on it when it was unchecked, and we should add 
				 * the song to the HashSet. If the checkbox is unchecked, that means the user 
				 * tapped on it when it was checked, so we should remove the song from the 
				 * HashSet.
				 */
				if (checkbox.isChecked()) {
					view.setBackgroundColor(0xCC0099CC);
					PlaylistEditorActivity.songDBIdsList.add((String) view.getTag(R.string.song_id));
				} else {
					view.setBackgroundColor(0x00000000);
					PlaylistEditorActivity.songDBIdsList.remove((String) view.getTag(R.string.song_id));
				}
				
			}
			
		});
		
		TextView instructions = (TextView) rootView.findViewById(R.id.songs_music_library_editor_instructions);
		instructions.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		instructions.setPaintFlags(instructions.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		return rootView;
	}

