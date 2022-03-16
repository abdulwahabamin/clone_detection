    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        lv=(ListView)findViewById(R.id.listView);
        al1=new ArrayList<String>();
        al2=new ArrayList<String>();
        al3=new ArrayList<BluetoothDevice>();
        lv.setOnItemClickListener(this);
        adapter=BluetoothAdapter.getDefaultAdapter();
        getPairedDevices();

    }

