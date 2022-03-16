	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		Intent intent = getIntent();
		info = (MP3Info) intent.getSerializableExtra("mp3info");    //get data from previous activity

		beginBtn = (ImageButton) findViewById(R.id.begin);
		pauseBtn = (ImageButton) findViewById(R.id.pause);
		stopBtn = (ImageButton) findViewById(R.id.stop);
		lrcTextView=(TextView)findViewById(R.id.lrcTextView);

		beginBtn.setOnClickListener(beginListener);
		pauseBtn.setOnClickListener(pauseListener);
		stopBtn.setOnClickListener(stopListener);
		
	}

