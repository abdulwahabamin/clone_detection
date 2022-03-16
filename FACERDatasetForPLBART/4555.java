	@Override
	public void onResume() {
        //Log.e("RESUME", "FileExploreFrAGMENT: " + this.getClass().getCanonicalName());
        //Validator.calldata();


		super.onResume();
		State.sectionsClearBackstack();
		State.setCurrentSection(State.SECTION_FILE_EXPLORE);
		//fm.init(activity);
		path = (TextView) view.findViewById(R.id.files_directory_path);
		info = (TextView) view.findViewById(R.id.files_directory_info);
		
		files = (TextView) view.findViewById(R.id.files_directory_info_files);
		title = (TextView) view.findViewById(R.id.files_directory_title);
		
		list=(ListView) view.findViewById(R.id.files_list);
        list.setAdapter(null);
		listImages=(GridView)  view.findViewById(R.id.files_list_grid);
        listImages.setAdapter(null);

		loading = activity.findViewById(R.id.loading);


		Fab.set(activity, null, null, upDirectoryListener);

		refresh();





	}

