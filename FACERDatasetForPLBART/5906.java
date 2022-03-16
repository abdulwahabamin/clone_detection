	public void onClick(DialogInterface dialog, int which)
	{
		if(dialog == rename_dialog) renameFile();
		else if(dialog == newfolder_dialog) createFolder();
		else if(dialog == new_search_dialog)
		{
			String name = new_search_dialog.getName();
			if(name != null && name.length() > 0) searchForFiles(name);
		}
	}

