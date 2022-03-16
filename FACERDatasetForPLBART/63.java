	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_chat);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	
		//
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		titlebar = (TextView) findViewById(R.id.chatpage_titlebartextview);
		ImageButton back = (ImageButton) findViewById(R.id.chatpage_backbutton);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		
		connectButton = (ImageButton)findViewById(R.id.chatpage_connect);
		connectButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				connectDevice(getIntent(), false);
			}
		});

		//
		conversationArrayAdapter = new ConversationListViewAdapter(this);
		//�??示用户
		conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, getString(R.string.hint_haotoconnect)));
		conversationArrayAdapter.addItemRenderer(new ItemRenderer(ItemRenderer.TYPE_HINT, getString(R.string.hint_iffailed)));
		
		//
		conversationView = (ListView) findViewById(R.id.chatpage_talkcontentlistview);
		conversationView.setAdapter(conversationArrayAdapter);
		outEditText = (EditText) findViewById(R.id.chatpage_inputmessageedittext);
		outEditText.setOnEditorActionListener(mWriteListener);

		sendButton = (Button) findViewById(R.id.button_send);
		sendButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				TextView view = (TextView) findViewById(R.id.chatpage_inputmessageedittext);
				String message = view.getText().toString();
				sendMessage(message);
			}
		});
	}

