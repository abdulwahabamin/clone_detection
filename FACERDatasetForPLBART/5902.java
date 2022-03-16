	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		int position = ((AdapterView.AdapterContextMenuInfo)menuInfo).position;
		if(position > 0 || parent_dir == null) // not for ".."
		{
			Map<String,String> map = list_of_maps.get(position);
			String icon = map.get(ICON);
			if(icon.equals(ICON_CHECKED_FILE) || icon.equals(ICON_CHECKED_FOLDER))
				getMenuInflater().inflate(R.menu.contextmenu_sel, menu);
			else
				getMenuInflater().inflate(R.menu.contextmenu_unsel, menu);

			menu.setHeaderTitle(map.get(NAME));
			menu.findItem(R.id.contextmenu_rename).setEnabled(is_current_dir_writable);
		}
	}

