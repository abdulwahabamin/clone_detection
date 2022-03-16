	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tvArea = (TextView) findViewById(R.id.tvArea);

		// Check if the database exists before copying
		try {
			boolean initialiseDatabase = (new File(Config.DB_PATH + Config.DB_NAME)).exists();
			if (initialiseDatabase == false) {
				CheckDBFile();
			}

			// Check_position_no();
			String areano = Func.Check_position_no();
			System.out.println("areano is " + areano);
			if (areano.length() > 0) {
				new UpdateData(this).execute(getApplicationContext());
			} else {
				Intent intent = new Intent();
				intent.setClass(WeatherActivity.this, SelectArea.class);
				startActivity(intent);
			}

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
		}
	}

