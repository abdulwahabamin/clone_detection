	public void onPrepareDialog(int id, Dialog dialog, Bundle args)
	{
		switch(id)
		{
			case R.id.contextmenu_rename:
				String name = args.getString(NAME);
				rename_dialog.edittext.setText(name);
				rename_dialog.old_name = name;
				break;
		}
	}

