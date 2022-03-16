	public boolean onOptionsItemSelected(MenuItem item)
	{
		super.onOptionsItemSelected(item);
		int item_id = item.getItemId();
		switch(item_id)
		{
			case R.id.mainactivity_menu_select_all:
				selectAll(false);
				break;
			case R.id.mainactivity_menu_invert_selection:
				selectAll(true);
				break;
			case R.id.mainactivity_menu_copy:
				getSelectedFiles();
				action_cut = false;
				break;
			case R.id.mainactivity_menu_cut:
				getSelectedFiles();
				action_cut = true;
				break;
			case R.id.mainactivity_menu_newfolder:
				showDialog(R.id.mainactivity_menu_newfolder);
				break;
			case R.id.mainactivity_menu_paste:
				pasteFiles();
				break;
			case R.id.mainactivity_menu_delete:
				deleteFiles();
				break;
			case R.id.mainactivity_menu_new_search:
				showDialog(R.id.mainactivity_menu_new_search);
				break;
			case R.id.mainactivity_menu_search_results:
				searchResults();
				break;
		}
		return true;
	}

