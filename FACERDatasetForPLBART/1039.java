	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        
        context = this;
        create = (Button) findViewById(R.id.button1);
        username = (EditText) findViewById(R.id.textView1);
        roomName = (EditText) findViewById(R.id.textView2);
        
        create.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (username.getText().toString().length() > 0)
				{
					
					enableBt();
				}
				
			}
		});
        
	}

