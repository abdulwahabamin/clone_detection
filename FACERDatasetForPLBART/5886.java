	public void onListItemClick(ListView l, View v, int position, long id)
	{
		File f = list_of_files.get(position);
		if(f.isDirectory()) // parent or subfolder
			setCurrentDir(f);
		// do nothing on a file
	}

