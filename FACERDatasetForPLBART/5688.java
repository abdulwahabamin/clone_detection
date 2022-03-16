	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_NEW_FOLDER:
			showDialog(DIALOG_NEW_FOLDER);
			return true;
			
		case MENU_MULTI_SELECT:
            promptMultiSelect();
			return true;
			
		case MENU_INCLUDE_IN_MEDIA_SCAN:
			includeInMediaScan();
			return true;

		case MENU_EXCLUDE_FROM_MEDIA_SCAN:
			excludeFromMediaScan();
			return true;
			
		case MENU_SETTINGS:
			showSettings();
			return true;
			
		case MENU_FILTER:
			showDialog(DIALOG_FILTER);
			return true;
		
		case MENU_BOOKMARKS:
			showDialog(DIALOG_BOOKMARKS);
			return true;
			
		case MENU_REFRESH:
			refreshList();
			return true;

		case MENU_BACKUPSETTINGS:
			showBackupSettings();
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

