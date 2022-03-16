    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Constants.D) Log.e(Constants.TAG, "+++ ON CREATE +++");
        setContentView(R.layout.main);
        
        
        if(BluetoothHandler.isSetup())
        	mHandler = BluetoothHandler.getIns();
        else
        	mHandler = BluetoothHandler.setup(this);
        
        
        
        // Initialize the array adapter for the conversation thread
        mConversationArrayAdapter = new CustomArrayAdapter(this, R.layout.message);
        mConversationView = (ListView) findViewById(R.id.in);
        mConversationView.setAdapter(mConversationArrayAdapter);

        // Initialize the compose field with a listener for the return key
        mOutEditText = (EditText) findViewById(R.id.edit_text_out);
        mOutEditText.setOnEditorActionListener(mWriteListener);

        // Initialize the send button with a listener that for click events
        mSendButton = (Button) findViewById(R.id.button_send);
        mSendButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Send a message using content of the edit text widget
                TextView view = (TextView) findViewById(R.id.edit_text_out);
                String message = view.getText().toString();
                sendMessage(message);
            }
        });
        
        // Initialize the buffer for outgoing messages
        mOutStringBuffer = new StringBuffer("");

        mHandler.setConversationAdapter(mConversationArrayAdapter);
        

        // Get local Bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        
        /*
        // this works but it is Deprecated
		Object obj = getLastNonConfigurationInstance();

	    if(null != obj){//if there is saved adapter - restore it
	    	mChatService = (BluetoothChatService)obj;
	    }
	    */
        
    }

