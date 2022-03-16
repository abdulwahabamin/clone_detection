	public void renameFile()
	{
		String new_name = rename_dialog.getName();
		if(new_name != null && new_name.length() > 0)
		{
			try
			{
				File	old_file = new File(current_dir, rename_dialog.old_name),
					new_file = new File(current_dir, new_name);
				if(new_file.exists())
					showToast(R.string.already_exists);
				else if(old_file.renameTo(new_file))
				{
					updateFileList();
					showToast(android.R.string.ok);
				}
				else showToast(R.string.cannot_rename);
			}
			catch(Exception e)
			{
				showToast(R.string.cannot_rename);
			}
		}
	}

