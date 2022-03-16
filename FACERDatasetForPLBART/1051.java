	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        
        
        username = (EditText) findViewById(R.id.editText1);
        roomName = (EditText) findViewById(R.id.editText2);
       
        join = (Button) findViewById(R.id.button1);
        
        
        join.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				connectThread = new ConnectThread(null);
				connectThread.run();
			}
		});
	}

