	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setCurrentDir(root_dir);
		mime_type_map = MimeTypeMap.getSingleton();
		toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
		registerForContextMenu(getListView());
		clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
		selected_files = new ArrayList<File>();
		files_found = new ArrayList<File>();
	}

