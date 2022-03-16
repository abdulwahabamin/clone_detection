	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Uri intent_uri = getIntent().getData();
		if(intent_uri != null)
		{
			try
			{
				File f = new File(intent_uri.getPath());
				if(f.exists() && f.isDirectory())
					setCurrentDir(f);
				else
					setCurrentDir(root_dir);
			}
			catch(Exception e)
			{
				setCurrentDir(root_dir);
			}
		}
		else setCurrentDir(root_dir);
	}

