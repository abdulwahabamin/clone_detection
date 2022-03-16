    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        adapter=BluetoothAdapter.getDefaultAdapter();
        lv=(ListView)findViewById(R.id.list);
        et=(EditText)findViewById(R.id.editText);
        al=new ArrayList<String>();
        arr=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,al);
        bar=getSupportActionBar();
        Intent intn=getIntent();
        Bundle bundle=intn.getExtras();
        boolean b=bundle.getBoolean("isClient");
        bar.setTitle(adapter.getName());
        lv.setAdapter(arr);
        if(b)
        {
            BluetoothDevice bd=(BluetoothDevice)bundle.get("server");
            String n=bd.getName();
            bar.setSubtitle("Connected to:"+n);
            bcs=new BluetoothChatService(true,bd,h);
        }
        else
        {
            bcs=new BluetoothChatService(false,null,h);

        }
    }

