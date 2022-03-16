	public void addDirItem(File f)
	{
		list_of_files.add(f);
		date.setTime(f.lastModified());
		addListItem(
			ICON_UNCHECKED_FOLDER,
			show_path ? f.getPath() : f.getName(),
			"",
			date_format.format(date)
		);
	}

