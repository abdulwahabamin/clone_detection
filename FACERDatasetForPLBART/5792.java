	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This activity is never shown to the user.
        setContentView(new RelativeLayout(this));
        Intent receivedIntent = getIntent();
        if(receivedIntent != null){
        	Uri uri = receivedIntent.getData();
        	source = uri;
        	if(uri.getScheme().equals("file"))
        		processFile(uri);
        	else if(uri.getScheme().equals("content"))
        		processContent(uri);
        }
        else{
			Toast.makeText(this, R.string.saveas_no_file_picked, Toast.LENGTH_SHORT).show();
        }
    }

