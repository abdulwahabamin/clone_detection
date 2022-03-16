    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        context = getApplicationContext();
        mUiUtils = new UiUtils(context);
        chatSetUpViewModel = ViewModelProviders.of(UserList.this).get(ChatSetUpViewModel.class);
        chatSetUpViewModel.init();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        startServerButton = findViewById(R.id.create);
        pairButton = findViewById(R.id.pair);
        userListAdapter =new UserListAdapter(context, preferenceManager, pairedDevices);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        myBroadcastReceiver = new MyBroadcastReceiver();
        preferenceManager = new PreferenceManager(context);
        deviceObserver = new Observer<List<BluetoothDevice>>() {
            @Override
            public void onChanged(@Nullable List<BluetoothDevice> devices) {
                if (devices != null){
                    userListAdapter.setData(devices);
                }
            }
        };
        filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myBroadcastReceiver , filter);



        pairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, " pair : about to start method");

                pairDevice(v);

            }
        });

        startServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, " create : about to start method");
                startServer(v);
            }
        });

        showPairedDevices();

    }

