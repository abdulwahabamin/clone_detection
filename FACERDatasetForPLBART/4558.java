	private void displayFolder() {
		//BLog.e("displayFolder");
		loadFileList();
		if(fm.getSelectedFiles().isEmpty()) {
			if(State.getFileExploreState()==State.FILE_EXPLORE_STATE_STANDALONE) {
				ActionBarManager.setActionBarBackOnlyWithLogo(activity,R.drawable.icon, activity.getResources().getString(R.string.label_files),R.menu.file_explore,R.color.actionbar_basic);
			} else {
				ActionBarManager.setActionBarBackOnlyWithLogo(activity,R.drawable.icon, activity.getResources().getString(R.string.label_files),R.menu.basic,R.color.actionbar_basic);
			}
			fileSelectedActionSelecter.mMode=null;
			fileSelectedActionSelecter.isActionModeShowing = false;
		} else {
			if(State.getFileExploreState()==State.FILE_EXPLORE_STATE_STANDALONE) {
				ActionBarManager.setActionBarBackOnlyWithLogo(activity,R.drawable.icon, activity.getResources().getString(R.string.label_files),R.menu.file_explore,R.color.actionbar_basic);
			} else {
				ActionBarManager.setActionBarBackOnlyWithLogo(activity,R.drawable.icon, activity.getResources().getString(R.string.label_files),R.menu.basic,R.color.actionbar_basic);
			}
			if(fileSelectedActionSelecter.mMode==null) {
				fileSelectedActionSelecter.mMode = ((AppCompatActivity)activity).startSupportActionMode(fileSelectedActionSelecter);
				//Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
				//toolbar.startActionMode(fileSelectedActionSelecter)
			}
			fileSelectedActionSelecter.updateTitle();
			fileSelectedActionSelecter.isActionModeShowing = true;
		}



		//apadpter
		fileSelectedActionSelecter.setWipeonfinish(true);

		File f= fm.getCurrentDirectory();
		title.setText(f.getName());
		path.setText(f.getAbsolutePath());
		info.setText(""+ fm.getCurrentDirectoryCount());
		files.setText("" + fm.getCurrentFileCount());

        int gopos=0;
        if(State.hasStateObject(State.SECTION_FILE_EXPLORE,StateObject.INT_LISTVIEW_FIRST_VIEWABLE)) {
            gopos=State.getStateObjectInt(State.SECTION_FILE_EXPLORE, StateObject.INT_LISTVIEW_FIRST_VIEWABLE);

            State.setFolderPosition(fm.getCurrentDirectory().getAbsolutePath(), gopos);
        } else {
            gopos=State.getFolderPosition(fm.getCurrentDirectory().getAbsolutePath());
        }
        if(fm.isCurrentDirImages()) {
            listImages.setSelection(gopos);
        } else {
            list.setSelection(gopos);
        }
        State.clearStateObjects(State.SECTION_FILE_EXPLORE);
	}

