	public boolean onPrepareOptionsMenu(Menu menu)
	{
		super.onPrepareOptionsMenu(menu);
		menu.findItem(R.id.mainactivity_menu_edit).setEnabled(is_current_dir_writable);
		return true;
	}

