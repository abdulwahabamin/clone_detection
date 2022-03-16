    private void init() {

        rv= (RecyclerView) findViewById(R.id.recyclerView);
        message= (EditText) findViewById(R.id.ed_msg);
        send= (ImageButton) findViewById(R.id.btn_send);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        title= (TextView) toolbar.findViewById(R.id.tv_name);
        status= (TextView) toolbar.findViewById(R.id.tv_status);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list=new ArrayList<>();

        manager = new LinearLayoutManager(this);
        manager.setStackFromEnd(true);
        manager.setReverseLayout(true);
        rv.setLayoutManager(manager);


        name_other=getIntent().getStringExtra(Constants.NAME);
        macAddress_other =getIntent().getStringExtra(Constants.MAC_ADDRESS);
        macAddress_my= BlueHelper.getBluetoothAdapter().getAddress();

        device_other=BlueHelper.getBluetoothAdapter().getRemoteDevice(macAddress_other);

        title.setText(name_other);

        cAdapter=new ChatAdapter(this,list,macAddress_my);

        rv.setAdapter(cAdapter);

        current_msg_count = total_msg_count =0;

        pagination_done=false;

        if (device_other.getBondState()!=BluetoothDevice.BOND_BONDED)
        {
            device_other.createBond();
        }
    }

