	@Override
	public void onResume() {
		//Log.e("RESUME", "ZipFileExplore");
		super.onResume();
		State.setCurrentSection(State.SECTION_FILE_EXPLORE_ARCHIVE);

		//fm.init(activity);
		headpod =  view.findViewById(R.id.files_header);
		extractpod =  view.findViewById(R.id.extract_files_header);
		path = (TextView) view.findViewById(R.id.files_directory_path);
		info = (TextView) view.findViewById(R.id.files_directory_info);

		files = (TextView) view.findViewById(R.id.files_directory_info_files);
		title = (TextView) view.findViewById(R.id.files_directory_title);

		list=(ListView) view.findViewById(R.id.files_list);
		//listImages=(GridView)  view.findViewById(R.id.files_list_grid);
        chooseFolder=(ImageView) view.findViewById(R.id.file_explore_choose_folder);
        chooseFolder.setClickable(true);
        chooseFolder.setOnClickListener(changeFolderListner);

        zipFolder=(TextView) view.findViewById(R.id.zip_folder);
        zipFolderPath=(TextView) view.findViewById(R.id.zip_folder_path);

		extractNow=(Button) view.findViewById(R.id.file_explore_extract_now);
		extractNow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(!BrowseService.isArchiving()) {
                    started=true;
                    recheckArchingstatus.postDelayed(runCheckingArchive, 100);
                    BrowseService.unArchiveFiles(fm.getCurrentDirectory().getAbsolutePath(),extractToFolder);

				}
			}
		});

		Fab.hide();
		//header=(LinearLayout) view.findViewById(R.id.files_header);
		refresh();

	}

