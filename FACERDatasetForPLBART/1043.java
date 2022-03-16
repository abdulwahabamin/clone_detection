	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        
        
        username = getIntent().getExtras().getString("un");
        context = this;
        
        acceptor.run();
        
        
        
	}

