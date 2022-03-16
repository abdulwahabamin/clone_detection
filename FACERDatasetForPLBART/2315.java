	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		// Modifications to convert EulaActivity into
		// NewVersionActivity:
		String version = VersionUtils.getVersionNumber(this);
		String title = getString(R.string.oi_distribution_name_and_version, 
				mAppName, version);
		String message = getString(R.string.oi_distribution_newversion_message, 
				mAppName);
		message += "\n\n" + getString(R.string.oi_distribution_newversion_recent_changes);
		
		mText1.setText(title);
		mText2.setText(message);
		mText.setText(readTextFromRawResource(R.raw.recent_changes, true));
		
		mAgree.setText(R.string.oi_distribution_newversion_continue);
		mDisagree.setVisibility(View.GONE);
		View v = findViewById(R.id.space);
		v.setVisibility(View.GONE);
	}

