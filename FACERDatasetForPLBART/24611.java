	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		Intent intent = getIntent();
		info = (MP3Info) intent.getSerializableExtra("mp3info");

		beginBtn = (ImageButton) findViewById(R.id.begin);
		pauseBtn = (ImageButton) findViewById(R.id.pause);
		stopBtn = (ImageButton) findViewById(R.id.stop);

		beginBtn.setOnClickListener(beginListener);
		pauseBtn.setOnClickListener(pauseListener);
		stopBtn.setOnClickListener(stopListener);
		
	}

