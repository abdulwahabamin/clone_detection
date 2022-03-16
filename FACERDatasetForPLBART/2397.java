 	@Override
 	public boolean onCreateOptionsMenu(Menu menu) {
 		super.onCreateOptionsMenu(menu);

 		menu.add(0, MENU_NEW_FOLDER, 0, R.string.menu_new_folder).setIcon(
 				android.R.drawable.ic_menu_add).setShortcut('0', 'f');

		mIncludeMediaScanMenuItem = menu.add(0, MENU_INCLUDE_IN_MEDIA_SCAN, 0, R.string.menu_include_in_media_scan).setShortcut('1', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);
		mExcludeMediaScanMenuItem = menu.add(0, MENU_EXCLUDE_FROM_MEDIA_SCAN, 0, R.string.menu_exclude_from_media_scan).setShortcut('1', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);

 		UpdateMenu
 				.addUpdateMenu(this, menu, 0, MENU_UPDATE, 0, R.string.update);
 		menu.add(0, MENU_ABOUT, 0, R.string.about).setIcon(
 				android.R.drawable.ic_menu_info_details).setShortcut('0', 'a');

 		return true;
 	}

