	@Override
	public void onResume() {
		super.onResume();
		State.setCurrentSection(State.SECTION_FILE_CREATE_ARCHIVE);
		fm=(FileManagerDisk) State.getCachedFileManager(FileManagerDisk.class);
		if(fm==null) {
			fm = new FileManagerDisk(State.getStateObjectString(State.SECTION_FILE_CREATE_ARCHIVE, StateObject.STRING_FILE_PATH));
            String chahcedSelected=State.getStateObjectString(State.SECTION_FILE_CREATE_ARCHIVE, StateObject.STRING_BJSON_OBJECT);
            if(chahcedSelected!=null) {
                JSONArray jar = new JSONArray(chahcedSelected);
                if (jar != null && jar.length() > 0) {
                    for (int i = 0; i < jar.length(); i++) {
                        fm.addSelectedFile(new FileItem(jar.getString(i)));
                    }
                }
            }
		}
		String changeFolder=State.getStateObjectString(State.SECTION_POP_FOLDER_CHOOSER, StateObject.STRING_VALUE);
		if(changeFolder!=null)
			fm.setCurrentDirectory(activity,changeFolder);

		State.clearStateObjects(State.SECTION_FILE_CREATE_ARCHIVE);
		State.clearStateObjects(State.SECTION_POP_FOLDER_CHOOSER);

		Fab.hide();
		chooseFolder=(ImageView) view.findViewById(R.id.file_explore_choose_folder);
		chooseFolder.setClickable(true);
		chooseFolder.setOnClickListener(changeFolderListner);
		refresh();
	}

