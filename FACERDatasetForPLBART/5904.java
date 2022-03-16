	public Dialog onCreateDialog(int id, Bundle args)
	{
		switch(id)
		{
			case R.id.contextmenu_rename:
				rename_dialog = new FileNameDialog(this, this);
				rename_dialog.setTitle(R.string.rename);
				return rename_dialog;
			case R.id.mainactivity_menu_newfolder:
				newfolder_dialog = new FileNameDialog(this, this);
				newfolder_dialog.setTitle(R.string.newfolder);
				return newfolder_dialog;
			case R.id.mainactivity_menu_new_search:
				new_search_dialog = new FileNameDialog(this, this);
				new_search_dialog.setTitle(R.string.new_search);
				new_search_dialog.edittext.setHint(R.string.name_or_part);
				return new_search_dialog;
			default:
				return null;
		}
	}

