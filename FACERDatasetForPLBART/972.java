	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		setContentView(R.layout.server);
		ActionBar actionBar = this.getActionBar();
		actionBar.setTitle("�����������");
		actionBar.setIcon(getResources().getDrawable(R.drawable.launcher));		
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		MyListener listener = new MyListener();
		target=(Button)findViewById(R.id.target);
		target.setOnClickListener(listener);
		load=(Button)findViewById(R.id.load);
		load.setOnClickListener(listener);
		keep=(Button)findViewById(R.id.keep);
		keep.setOnClickListener(listener);
		zero=(Button)findViewById(R.id.zero);
		zero.setOnClickListener(listener);
		netWeight=(Button)findViewById(R.id.netWeight);
		netWeight.setOnClickListener(listener);
		turn=(Button)findViewById(R.id.turn);
		turn.setOnClickListener(listener);
		serverStateTextView = (TextView) findViewById(R.id.serverStateTxt);
		serverStateTextView.setText("�ȴ�����...");
	
		msgEditText = (EditText) findViewById(R.id.serverEditText);

/*		sendMsgEditText = (EditText) findViewById(R.id.serverSendEditText);

		sendBtn = (Button) findViewById(R.id.serverSendMsgBtn);
		sendBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("".equals(sendMsgEditText.getText().toString().trim())) {
					Toast.makeText(ServerActivity.this, "���벻��Ϊ��",
							Toast.LENGTH_SHORT).show();
				} else {
					// ������Ϣ
					sendMess(sendMsgEditText.getText().toString());
				}
			}
		});

		sendBtn.setEnabled(false);*/
	}

