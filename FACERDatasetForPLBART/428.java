    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById değerlerini gosterme işlemleri
        listen = findViewById(R.id.listen);
        send = findViewById(R.id.send);
        listDevices = findViewById(R.id.listDevices);
        listView = findViewById(R.id.listview);
        status = findViewById(R.id.status);
        messageBox = findViewById(R.id.msg);
        writeMessage = findViewById(R.id.writemsg);

        // adapter nesnesiyle bluetooth aygıtına erişim
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // bluetoothAdapter değeri açık değilse
        if (!bluetoothAdapter.isEnabled()){

            // bluetooth iznini kullanıcıdan istiyoruz.
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

            // enableIntent işlemi
            startActivityForResult(enableIntent,REQUEST_ENABLE_BLUETOOTH);
        }

        // implementListeners metodun çağrılması
        implementListeners();
    }

