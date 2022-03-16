	public void createFolder()
	{
		String new_name = newfolder_dialog.getName();
		if(new_name != null && new_name.length() > 0)
		{
			try
			{
				File new_folder = new File(current_dir, new_name);
				if(new_folder.exists())
					showToast(R.string.already_exists);
				else if(new_folder.mkdir())
				{
					updateFileList();
					showToast(android.R.string.ok);
				}
				else showToast(R.string.cannot_create_folder);
			}
			catch(Exception e)
			{
				showToast(R.string.cannot_create_folder);
			}
		}
	}

