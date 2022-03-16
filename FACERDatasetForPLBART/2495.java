	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_directory_activity);
		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Receive current directory path
		String currentPath = (String) getIntent().getCharSequenceExtra(
				"currentPath");
		path = currentPath;

		// Run initialiation methods
		populateFiles();
		setupListViewMulti();
		setupAdapter();
		setupListClick();
	}

