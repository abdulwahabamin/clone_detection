	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client);
		ActionBar actionBar = this.getActionBar();
		actionBar.setTitle("�ͻ���������");
		actionBar.setIcon(getResources().getDrawable(R.drawable.launcher));		
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(true);
		serversText = (TextView) findViewById(R.id.clientServersText);
		chatEditText = (EditText) findViewById(R.id.clientChatEditText);
		weight = (Button)findViewById(R.id.weight);
		weight.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMess("����666666kg");
			}
			
		});
/*		sendEditText = (EditText) findViewById(R.id.clientSendEditText);
		sendBtn = (Button) findViewById(R.id.clientSendMsgBtn);

		sendBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ������Ϣ
				if ("".equals(sendEditText.getText().toString().trim())) {
					Toast.makeText(ClientActivity.this, "���벻��Ϊ��",
							Toast.LENGTH_SHORT).show();
				} else {
					// ������Ϣ
					TransmitBean data = new TransmitBean();
					String msg = "�ͻ��ˣ�" + "  " +new Date().toLocaleString()
							+ " :\r\n" + sendEditText.getText().toString() + "\r\n";
					chatEditText.append(msg);
					data.setMsg(sendEditText.getText().toString());
					Intent sendDataIntent = new Intent(
							BluetoothTools.ACTION_DATA_TO_SERVICE);
					sendDataIntent.putExtra(BluetoothTools.DATA, data);
					sendBroadcast(sendDataIntent);
				}
			}
		});*/
	}

