	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = this.getActionBar();
		actionBar.setTitle("Ö÷½çÃæ");
		actionBar.setIcon(getResources().getDrawable(R.drawable.ic_launcher));		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		startServerBtn = (Button) findViewById(R.id.startServerBtn);
		startClientBtn = (Button) findViewById(R.id.startClientBtn);

		startServerBtn.setOnClickListener(btnClickListener);
		startClientBtn.setOnClickListener(btnClickListener);
	}

