	public void onCreateOptionsMenu(Menu menu) {
		// Remove items first so that they don't appear twice:
		menu.removeItem(mFirstMenuId + OFFSET_UPDATE);
		menu.removeItem(mFirstMenuId + OFFSET_ABOUT);
		
		if (UpdateDialog.isUpdateMenuNecessary(mActivity)) {
			menu.add(0, mFirstMenuId + OFFSET_UPDATE, 0, R.string.oi_distribution_menu_update).setIcon(
					android.R.drawable.ic_menu_info_details).setShortcut('9', 'u');
		}
		menu.add(0, mFirstMenuId + OFFSET_ABOUT, 0, R.string.oi_distribution_about).setIcon(
 				android.R.drawable.ic_menu_info_details).setShortcut('0', 'a');
	}

