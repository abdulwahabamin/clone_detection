 	@Override
 	public boolean onCreateOptionsMenu(Menu menu) {
 		super.onCreateOptionsMenu(menu);

 		int icon = android.R.drawable.ic_menu_add;
 		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
 			icon = R.drawable.ic_menu_add_folder;
 		}
 		MenuItem item = menu.add(0, MENU_NEW_FOLDER, 0, R.string.menu_new_folder).setIcon(
 				icon).setShortcut('0', 'f');
 		MenuCompat.setShowAsAction(item, MenuItem.SHOW_AS_ACTION_IF_ROOM);
 
 		if (mState == STATE_BROWSE) {
 		// Multi select option menu.
 	        menu.add(0, MENU_MULTI_SELECT, 0, R.string.menu_multi_select).setIcon(
 	                R.drawable.ic_menu_multiselect).setShortcut('1', 'm');
        }
			
		mIncludeMediaScanMenuItem = menu.add(0, MENU_INCLUDE_IN_MEDIA_SCAN, 0, R.string.menu_include_in_media_scan).setShortcut('2', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);
		mExcludeMediaScanMenuItem = menu.add(0, MENU_EXCLUDE_FROM_MEDIA_SCAN, 0, R.string.menu_exclude_from_media_scan).setShortcut('2', 's')
				.setIcon(android.R.drawable.ic_menu_gallery);
		
		menu.add(0, MENU_BOOKMARKS, 0, R.string.bookmarks).setIcon(
				R.drawable.ic_menu_star);
		

		menu.add(0, MENU_SETTINGS, 0, R.string.settings).setIcon(
				android.R.drawable.ic_menu_preferences).setShortcut('9', 'p');
		
		/* We don't want to allow the user to override a filter set
		 * by an application.
		 */
		if(mState != STATE_PICK_FILE) {
			menu.add(0, MENU_FILTER, 0, R.string.menu_filter).setIcon(
					android.R.drawable.ic_menu_search);
		}
		
		menu.add(0, MENU_REFRESH, 0, R.string.menu_refresh).setIcon(
				android.R.drawable.ic_menu_rotate);

 		mDistribution.onCreateOptionsMenu(menu);
 		return true;
 	}

