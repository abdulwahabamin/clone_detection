    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer);
        bluetoothDevice = BluetoothActivity.mBluetoothDevice;
        bluetoothSocket = BluetoothActivity.mBluetoothSocket;
        final ConnectedThread ct = new ConnectedThread(bluetoothSocket);
        ct.start();

        messages = (TextView) findViewById(R.id.textView);
        inputMessage = (EditText) findViewById(R.id.editText);

        bt1 = (Button) findViewById(R.id.send);
        bt1.setOnClickListener(
                new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onClick(View v) {
                        if (!Objects.equals(inputMessage.getText().toString(), "")){
                            Log.d(TAG, "Clicked");
                            String msg = inputMessage.getText().toString().toUpperCase();
                            byte[] bytes = msg.getBytes();
                            ct.write(bytes);
                        }
                    }
                }
        );
    }

