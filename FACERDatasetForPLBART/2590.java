	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		setContentView(R.layout.oi_distribution_eula);
		
		// Extras are provided by checkEula() below.
		Intent i = getIntent();
		Bundle b = i.getExtras();
		mLaunchPackage = b.getString(EulaOrNewVersion.EXTRA_LAUNCH_ACTIVITY_PACKAGE);
		mLaunchClass = b.getString(EulaOrNewVersion.EXTRA_LAUNCH_ACTIVITY_CLASS);
		//mLaunchIntent 
		mLaunchIntent = b.getParcelable(EulaOrNewVersion.EXTRA_LAUNCH_ACTIVITY_INTENT);
		
		//mIntroContinue = (Button) findViewById(R.id.intro_continue);
		mAgree = (Button) findViewById(R.id.button1);
		mAgree.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				accept();
			}
		});
		
		mDisagree = (Button) findViewById(R.id.button2);
		mDisagree.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				refuse();
			}
		});

		mText1 = (TextView) findViewById(R.id.text1);
		mText2 = (TextView) findViewById(R.id.text2);
		mText = (TextView) findViewById(R.id.text);
		mImage = (ImageView) findViewById(R.id.imageview);
		
		mAppName = VersionUtils.getApplicationName(this);
		int iconRes = VersionUtils.getApplicationIcon(this);
		
		setTitle(mAppName);
		mImage.setImageResource(iconRes);

		String title = getString(R.string.oi_distribution_eula_title, 
				mAppName);
		String message = getString(R.string.oi_distribution_eula_message, 
				mAppName);
		
		mText1.setText(title);
		mText2.setText(message);
		mText.setText(readTextFromRawResource(R.raw.license_short, false));
	}

