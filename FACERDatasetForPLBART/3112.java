	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Intent intent;
		switch (item.getItemId()) {
		case MENU_NEW_FOLDER:
			showDialog(DIALOG_NEW_FOLDER);
			return true;
			
		case MENU_UPDATE:
			UpdateMenu.showUpdateBox(this);
			return true;

		case MENU_ABOUT:
			showAboutBox();
			return true;

		case MENU_INCLUDE_IN_MEDIA_SCAN:
			includeInMediaScan();
			return true;

		case MENU_EXCLUDE_FROM_MEDIA_SCAN:
			excludeFromMediaScan();
			return true;
/*
		case MENU_PREFERENCES:
			intent = new Intent(this, PreferenceActivity.class);
			startActivity(intent);
			return true;
			*/
		}
		return super.onOptionsItemSelected(item);

	}

