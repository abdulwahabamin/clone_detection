	@SuppressLint("NewApi")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_albums_music_library_editor, null);
		mApp = (Common) getActivity().getApplicationContext();

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
			rootView.setBackground(UIElementsHelper.getBackgroundGradientDrawable(getActivity()));
		} else {
			rootView.setBackgroundDrawable(UIElementsHelper.getBackgroundGradientDrawable(getActivity()));
		}
		
		cursor = mApp.getDBAccessHelper().getAllUniqueAlbumsNoBlacklist("");
		listView = (ListView) rootView.findViewById(R.id.musicLibraryEditorAlbumsListView);
		listView.setFastScrollEnabled(true);
		listView.setAdapter(new BlacklistedAlbumsMultiselectAdapter(getActivity(), cursor));
		
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
					view.setBackgroundColor(0xCCFF4444);
					AsyncBlacklistAlbumTask task = new AsyncBlacklistAlbumTask((String) view.getTag(R.string.album),
																		 (String) view.getTag(R.string.artist));
					task.execute(new String[] {"ADD"});
				} else {
					view.setBackgroundColor(0x00000000);
					AsyncBlacklistAlbumTask task = new AsyncBlacklistAlbumTask((String) view.getTag(R.string.album),
																		 (String) view.getTag(R.string.artist));
					task.execute(new String[] {"REMOVE"});
				}
				
			}
			
		});
		
		TextView instructions = (TextView) rootView.findViewById(R.id.albums_music_library_editor_instructions);
		instructions.setTypeface(TypefaceHelper.getTypeface(getActivity(), "RobotoCondensed-Light"));
		instructions.setPaintFlags(instructions.getPaintFlags() | Paint.ANTI_ALIAS_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
		instructions.setText(R.string.blacklist_manager_albums_instructions);
		
		//KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        	
            //Calculate navigation bar height.
            int navigationBarHeight = 0;
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
            
            listView.setClipToPadding(false);
            listView.setPadding(0, 0, 0, navigationBarHeight);
        }
		
		return rootView;
	}

