	public void updateFileList()
	{
		list_of_files.clear();
		list_of_maps.clear();
		if(parent_dir != null)
		{
			list_of_files.add(parent_dir);
			addListItem(
				ICON_UNCHECKED_FOLDER,
				"..",
				getString(R.string.upper_folder),
				""
			);
		}
		File[] files = current_dir.listFiles();
		if(files != null)
		{
			Arrays.sort(files);
			for(File f : files)
			{
				if(f.canRead())
				{
					if(f.isDirectory()) addDirItem(f);
					else if(f.isFile()) addFileItem(f);
				}
			}
		}
		simple_adapter.notifyDataSetChanged();
	}

