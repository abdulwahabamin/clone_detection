	private void displayFolder() {
		loadFileList();

//		ActionBarManager.setActionBarBackOnly(activity, activity.getResources().getString(R.string.choose_folder), R.menu.basic);


		File f= fm.getCurrentDirectory();
		title.setText(f.getName());
		path.setText(f.getAbsolutePath());

	}

