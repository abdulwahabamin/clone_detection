	public void addFileItem(File f)
	{
		list_of_files.add(f);
		date.setTime(f.lastModified());
		addListItem(
			ICON_UNCHECKED_FILE,
			show_path ? f.getPath() : f.getName(),
			Formatter.formatShortFileSize(this, f.length()),
			date_format.format(date)
		);
	}

