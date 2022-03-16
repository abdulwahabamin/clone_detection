    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Iniciar los ArrayList y el adaptador Bluetooth. //
        discoveredDevices = new ArrayList<BluetoothDevice>();
        discoveredDevicesnames = new ArrayList<String>();

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Inicialización de los textView para mostrar los mensajes recibidos. //
        txtData = (TextView) findViewById(R.id.txtData);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

    }

