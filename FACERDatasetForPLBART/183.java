    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isSupportBle();

        bindView();

        initData();

        initView();

        registerBluetoothReceiver();

        requestPermissions();

        startDiscovery();

        beDiscovered();

        startAcceptService();

    }

