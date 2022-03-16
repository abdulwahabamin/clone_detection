	@Override
	public void onCreateContextMenu(ContextMenu menu, View view,
			ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info;
		try {
			info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		} catch (ClassCastException e) {
			Log.e(TAG, "bad menuInfo", e);
			return;
		}
/*
		Cursor cursor = (Cursor) getListAdapter().getItem(info.position);
		if (cursor == null) {
			// For some reason the requested item isn't available, do nothing
			return;
		}
*/
        IconifiedTextListAdapter adapter = (IconifiedTextListAdapter) getListAdapter();
        
        if (adapter == null) {
      	  return;
        }
        
        IconifiedText it = (IconifiedText) adapter.getItem(info.position);
		menu.setHeaderTitle(it.getText());
		menu.setHeaderIcon(it.getIcon());
		File file = FileUtils.getFile(currentDirectory, it.getText());

		
		if (!file.isDirectory()) {
			if (mState == STATE_PICK_FILE) {
				// Show "open" menu
				menu.add(0, MENU_OPEN, 0, R.string.menu_open);
			}
			menu.add(0, MENU_SEND, 0, R.string.menu_send);
		}
		menu.add(0, MENU_MOVE, 0, R.string.menu_move);
		
		if (!file.isDirectory()) {
			menu.add(0, MENU_COPY, 0, R.string.menu_copy);
		}
		
		menu.add(0, MENU_RENAME, 0, R.string.menu_rename);
		menu.add(0, MENU_DELETE, 0, R.string.menu_delete);

		//if (!file.isDirectory()) {
	        Uri data = Uri.fromFile(file);
	        Intent intent = new Intent(null, data);
	        String type = mMimeTypes.getMimeType(file.getName());

	        intent.setDataAndType(data, type);
	        //intent.addCategory(Intent.CATEGORY_SELECTED_ALTERNATIVE);

	        Log.v(TAG, "Data=" + data);
	        Log.v(TAG, "Type=" + type);

	        if (type != null) {
			// Add additional options for the MIME type of the selected file.
				menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
						new ComponentName(this, FileManagerActivity.class), null, intent, 0, null);
	        }
		//}
	}

