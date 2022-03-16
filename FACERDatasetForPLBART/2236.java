 	@Override
 	public boolean onCreateOptionsMenu(Menu menu) {
 		super.onCreateOptionsMenu(menu);

 		menu.add(0, MENU_NEW_FOLDER, 0, R.string.menu_new_folder).setIcon(
 				android.R.drawable.ic_menu_add).setShortcut('0', 'f');
 
 		if (mState == STATE_BROWSE) {
 		// Multi select option menu.
 	        menu.add(0, MENU_MULTI_SELECT, 0, R.string.menu_multi_select).setIcon(
 	                R.drawable.ic_menu_multiselect).setShortcut('1', 'm');
        }
			
		mIncludeMediaScanMenuItem = menu.add(0, MENU_INCLUDE_IN_MEDIA_SCAN, 0, R.string.menu_include_in_media_scan).setShortcut('2', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);
		mExcludeMediaScanMenuItem = menu.add(0, MENU_EXCLUDE_FROM_MEDIA_SCAN, 0, R.string.menu_exclude_from_media_scan).setShortcut('2', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);

		menu.add(0, MENU_SETTINGS, 0, R.string.settings).setIcon(
				android.R.drawable.ic_menu_preferences).setShortcut('9', 's');

 		mDistribution.onCreateOptionsMenu(menu);
 		
 		return true;
 	}

