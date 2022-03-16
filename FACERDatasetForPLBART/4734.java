	@Override
	public void onResume() {
       // Log.e("RESUME", "PopFolderChoose - Fragment: " + this.getClass().getCanonicalName());
		super.onResume();
		State.setCurrentSection(State.SECTION_POP_FOLDER_CHOOSER);
		amb = new ActionModeBack(activity, activity.getResources().getString(R.string.choose_folder)
				,R.menu.search
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {

			}
		});
		if(android.os.Build.VERSION.SDK_INT>= 19) {

			ActionBarManager.setActionBarBackV19(activity, amb);
			//setActionBarBackV19();
		} else {
			ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.choose_folder), R.menu.image_slider,amb);
		}

		String startFolder = State.getStateObjectString(State.SECTION_POP_FOLDER_CHOOSER, StateObject.STRING_FILE_PATH);
		if(startFolder!=null)
			fm.setCurrentDirectory(activity,startFolder);


		path = (TextView) view.findViewById(R.id.files_directory_path);

		title = (TextView) view.findViewById(R.id.files_directory_title);

		list=(ListView) view.findViewById(R.id.pop_files_list);
        list.setAdapter(null);
		loading = activity.findViewById(R.id.loading);



		refresh();

        Fab.set(activity, null, null, upDirectoryListener);



	}

