	public boolean onContextItemSelected(MenuItem item)
	{
		int position = ((AdapterView.AdapterContextMenuInfo)item.getMenuInfo()).position;
		Map<String,String> map = list_of_maps.get(position);
		switch(item.getItemId())
		{
			case R.id.contextmenu_select:
				selectItem(map, false);
				simple_adapter.notifyDataSetChanged();
				break;
			case R.id.contextmenu_unselect:
				selectItem(map, true);
				simple_adapter.notifyDataSetChanged();
				break;
			case R.id.contextmenu_copypath:
				clipboard.setText(list_of_files.get(position).getPath());
				showToast(android.R.string.ok);
				break;
			case R.id.contextmenu_rename:
				Bundle b = new Bundle();
				b.putString(NAME, map.get(NAME));
				showDialog(R.id.contextmenu_rename, b);
				break;
		}
		return true;
	}

