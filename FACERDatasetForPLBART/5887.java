	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filelistactivity);
		list_of_files = new ArrayList<File>();
		list_of_maps = new ArrayList<Map<String,String>>();
		simple_adapter = new SimpleAdapter(
			this,
			list_of_maps,
			R.layout.filelistitem,
			new String[] { ICON, NAME, SIZE, DATE },
			new int[] {
				R.id.filelistitem_icon,
				R.id.filelistitem_name,
				R.id.filelistitem_size,
				R.id.filelistitem_date
			}
		);
		setListAdapter(simple_adapter);
		date_format = DateFormat.getInstance();
		date = new Date();
	}

