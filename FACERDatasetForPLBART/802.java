    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setSubtitle("");

        lvChat = (ListView) findViewById(R.id.lvChat);
        etMessage = (EditText) findViewById(R.id.edit_text_out);
        mSendButton = (ImageButton) findViewById(R.id.button_send);

        LayoutInflater myLayout = LayoutInflater.from(this);
        final View dialogView = myLayout.inflate(R.layout.custom_dialog_for_scan, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(dialogView);
        alertDialogBuilder.setCancelable(false);
        alertDialog = alertDialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        tvScanTitle = (TextView) dialogView.findViewById(R.id.tvScanTitle) ;
        lvScan = (ListView) dialogView.findViewById(R.id.lvScanDevices) ;
        tvScanDevices = (TextView) dialogView.findViewById(R.id.tvScanDevices) ;
        tvCancel = (TextView) dialogView.findViewById(R.id.tvCancel) ;
        tvEmpty = (TextView) dialogView.findViewById(R.id.tvEmpty) ;

        llBottomButtons = (LinearLayout) dialogView.findViewById(R.id.llBottomButtons) ;

        scanDevicesList = new ArrayList<>();
        chatList = new ArrayList<>();

        ActivityCompat.requestPermissions(this,new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
        }else{

        }

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, filter);

        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = etMessage.getText().toString();
                message = message.trim();
                sendMessage(message);

            }
        });

        tvScanDevices.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                alertDialog.dismiss();
                showDevices();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alertDialog.isShowing())alertDialog.dismiss();
            }
        });

        lvScan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BlueToothDeviceModel temp = (BlueToothDeviceModel) parent.getItemAtPosition(position) ;
                mChatService.connect(temp.getDevice(),true);
                if (alertDialog.isShowing())alertDialog.dismiss();
            }
        });

    }

