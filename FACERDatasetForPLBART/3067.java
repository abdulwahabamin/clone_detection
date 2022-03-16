	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		setContentView(RD.layout.eula);
		
		// Extras are provided by checkEula() below.
		Intent i = getIntent();
		Bundle b = i.getExtras();
		mLaunchPackage = b.getString(EXTRA_LAUNCH_ACTIVITY_PACKAGE);
		mLaunchClass = b.getString(EXTRA_LAUNCH_ACTIVITY_CLASS);
		
		//mIntroContinue = (Button) findViewById(R.id.intro_continue);
		mAgree = (Button) findViewById(RD.id.button1);
		mAgree.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				acceptEula();
			}
		});
		
		mDisagree = (Button) findViewById(RD.id.button2);
		mDisagree.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				refuseEula();
			}
		});
		
		TextView text = (TextView) findViewById(RD.id.text);
		text.setText(readLicenseFromRawResource(RD.raw.license_short));
		
	}

