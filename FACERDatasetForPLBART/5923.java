	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		show_path = true;
		for(File f : MainActivity.files_found)
		{
			if(f.isDirectory()) addDirItem(f);
			else if(f.isFile()) addFileItem(f);
		}
		simple_adapter.notifyDataSetChanged();
	}

