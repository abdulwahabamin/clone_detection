	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mContext = getActivity().getApplicationContext();
		mApp = (Common) getActivity().getApplicationContext();
		View rootView = inflater.inflate(R.layout.fragment_albums_music_library_editor, null);

		cursor = mApp.getDBAccessHelper().getAllUniqueAlbums("");
		listView = (ListView) rootView.findViewById(R.id.musicLibraryEditorAlbumsListView);
		listView.setFastScrollEnabled(true);
		listView.setAdapter(new PlaylistEditorAlbumsMultiselectAdapter(getActivity(), cursor));
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int which, long dbID) {
				CheckBox checkbox = (CheckBox) view.findViewById(R.id.albumCheckboxMusicLibraryEditor);
				checkbox.performClick();
				
				/* Since we've performed a software-click (checkbox.performClick()), all we have 
				 * to do now is determine the *new* state of the checkbox. If the checkbox is checked, 
				 * that means that the user tapped on it when it was unchecked, and we should add 
				 * the album's songs to the HashSet. If the checkbox is unchecked, that means the user 
				 * tapped on it when it was checked, so we should remove the album's songs from the 
				 * HashSet.
				 */
				if (checkbox.isChecked()) {
					view.setBackgroundColor(0xCC0099CC);
					AsyncGetAlbumSongIds task = new AsyncGetAlbumSongIds(mContext,
																		 (String) view.getTag(R.string.album),
																		 (String) view.getTag(R.string.artist));
					task.execute(new String[] {"ADD"});
				} else {
					view.setBackgroundColor(0x00000000);
					AsyncGetAlbumSongIds task = new AsyncGetAlbumSongIds(mContext, 
																		 (String) view.getTag(R.string.album),
																		 (String) view.getTag(R.string.artist));
					task.execute(new String[] {"REMOVE"});
				}
				
			}
			
		});
		
		TextView instructions = (TextView) rootView.findViewById(R.id.albums_music_library_editor_instructions);
		instructions.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		instructions.setPaintFlags(instructions.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		
		return rootView;
	}

