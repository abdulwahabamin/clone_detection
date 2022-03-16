	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.enterfilenameactivity);
		textview_label = (TextView)findViewById(R.id.enterfilenameactivity_label);
		edittext_path = (EditText)findViewById(R.id.enterfilenameactivity_path);
		button_do = (Button)findViewById(R.id.enterfilenameactivity_do);

		Uri intent_data = getIntent().getData();
		if(intent_data != null)
			edittext_path.setText( intent_data.getPath() );
	}

