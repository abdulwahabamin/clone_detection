	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		String type;
		Intent myIntent = this.getIntent();
		type=myIntent.getExtras().getString("sendBy");
		if(type.equals("server")){
			out = BluetoothServerConnection.out;
			in = BluetoothServerConnection.in;
		}
		else if(type.equals("client")){
			out = BluetoothClientConnection.out;
			in = BluetoothClientConnection.in;
		}
		RecieveData rd = new RecieveData();
		rd.execute();
	}

