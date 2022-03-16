	public void onListItemClick(ListView l, View v, int position, long id)
	{
		File f = list_of_files.get(position);
		if(f.isFile())
			openFile(f);
		else
			super.onListItemClick(l, v, position, id);
	}

