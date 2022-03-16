	public void setCurrentDir(File dir)
	{
		current_dir = dir;
		parent_dir = dir.getParentFile();
		is_current_dir_writable = current_dir.canWrite();
		updateFileList();
		setTitle(activity_label + ": " + dir.getPath());
	}

