    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        scan= (Button) findViewById(R.id.btn_scan);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        devices =new LinkedList<>();
        states =new LinkedList<>();

        sAdapter=new SearchAdapter(devices,states,this,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);



        permissionHelper=new PermissionHelper(this).setListener(this);

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);

        registerReceiver(mReceiver, filter);

        //startScanner();

        permissionHelper.requestPermission(
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},200);
    }

