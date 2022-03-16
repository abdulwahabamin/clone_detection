    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestPermissions();


        if (!isSupportBLE()) {
            showNotSupportBluetoothDialog();
            return;
        }

        initView();

        registerBluetoothReceiver();

        enableBLE();

    }

