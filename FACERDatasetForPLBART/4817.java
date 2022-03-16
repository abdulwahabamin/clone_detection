	public void refresh() {

		if(State.hasStateObject(State.SECTION_FILE_EXPLORE_ARCHIVE, StateObject.INT_MODE)) {
			mode = State.getStateObjectInt(State.SECTION_FILE_EXPLORE_ARCHIVE, StateObject.INT_MODE);
		}
        int useMenu=R.menu.archive;
        if (mode > 0) {
            useMenu=R.menu.basic;
            headpod.setVisibility(View.GONE);
            extractpod.setVisibility(View.VISIBLE);
        } else {
            headpod.setVisibility(View.VISIBLE);
            extractpod.setVisibility(View.GONE);
        }

		State.clearStateObjects(State.SECTION_FILE_EXPLORE_ARCHIVE);
		fm.refresh(activity);
		loadFileList();
		amb= new ActionModeBack(activity, activity.getResources().getString(R.string.label_archive)
				,useMenu
				, new ActionModeCallback() {
			@Override
			public void onActionMenuItem(ActionMode mode, MenuItem item) {
				onOptionsItemSelected(item);
			}
		});
		if(android.os.Build.VERSION.SDK_INT>= 19) {

			ActionBarManager.setActionBarBackV19(activity, amb);
			//setActionBarBackV19();
		} else {
			ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_archive), useMenu,amb);
		}


		//ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.label_archive), R.menu.archive, R.color.actionbar_basic);


		File f= fm.getCurrentDirectory();
		title.setText(f.getName());
		path.setText(f.getAbsolutePath());
		info.setText(""+ fm.getCurrentDirectoryCount());
		files.setText("" + fm.getCurrentFileCount());



        File p=f.getParentFile();
        if(p.exists()) {
            zipFolder.setText(p.getName());
            zipFolderPath.setText(p.getParent());
        } else {
            zipFolder.setText("");
            zipFolderPath.setText("/");
        }

        extractToFolder=p.getAbsolutePath();



		adapter.notifyDataSetChanged();


	}

