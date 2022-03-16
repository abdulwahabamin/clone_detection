	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.backup_layout);
				
		mAppLabel = (TextView)findViewById(R.id.backup_label);
		Button button = (Button)findViewById(R.id.backup_button_all);
		
		button.setOnClickListener(this);
		
		mAppList = new ArrayList<ApplicationInfo>();
		mPackMag = getPackageManager();
		
		get_downloaded_apps();
		setListAdapter(new TableView());
	}

