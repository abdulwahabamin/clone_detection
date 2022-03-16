    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Définir l'adapter des nouveaux devices
        newBluetoothDevices=new ArrayList<BluetoothDevice>();
        ListNew= new ArrayList<String>();
        decouvert= (ListView)findViewById(R.id.decouvert);
        adapterFound= new AdapterBluetooth(getApplicationContext(),ListNew);
        decouvert.setAdapter(adapterFound);

        bluetoothBroadCast= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action= intent.getAction();

                Toast.makeText(getApplicationContext(),"Dans le broadcast",Toast.LENGTH_SHORT).show();

                if(BluetoothDevice.ACTION_FOUND.equals(action)){
                    BluetoothDevice device= intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    newBluetoothDevices.add(device);
                    ListNew.add(device.getName());
                    adapterFound.notifyDataSetChanged();
                }
            }
        };

        decouvert.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDevice device=null;
                TextView textView=(TextView) view.findViewById(R.id.name);
                Toast.makeText(getApplicationContext(),"On a pu cliquer",Toast.LENGTH_SHORT).show();

                for(BluetoothDevice identite : newBluetoothDevices){
                    if(identite.getName().equals(textView.getText())){
                        device=identite;
                        Toast.makeText(getApplicationContext(),"Le periphérique distant a ete retrouve",Toast.LENGTH_SHORT).show();
                        client=new ConnectedAsClientThread(device,getApplicationContext(),bluetoothAdapter,getApplication());
                        break;
                    }

                }
                client.start();
            }
        });

        //Enrégistrer le broadcast
        IntentFilter filtre= new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(bluetoothBroadCast,filtre);

        //Enrégistrer le broadcast de connection
        IntentFilter connectionFiltre= new IntentFilter(BluetoothDevice.ACTION_ACL_CONNECTED);
        //registerReceiver(BondBroadCast,connectionFiltre);

        rechercher=(TextView)findViewById(R.id.rechercher);
        bluetoothAdapter= BluetoothAdapter.getDefaultAdapter();

        List<String> mylist= new ArrayList<String>();
        listView= (ListView)findViewById(R.id.appare);

        final Set<BluetoothDevice> pairedDevices= bluetoothAdapter.getBondedDevices();
            if(pairedDevices.size()>0){
                for(BluetoothDevice identite : pairedDevices){
                    mylist.add(identite.getName());
                }
            }
            ArrayAdapter arrayAdapter= new AdapterBluetooth(getApplicationContext(),mylist);
            listView.setAdapter(arrayAdapter);

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lancer la découverte
                bluetoothAdapter.startDiscovery();
                //On change le text de rechercher
                TextView CurrentTv=(TextView)v;
                CurrentTv.setText("Recherche en cours...");
                CurrentTv.setTextColor(getResources().getColor(R.color.gray));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BluetoothDevice device=null;
                TextView textView=(TextView) view.findViewById(R.id.name);
                Toast.makeText(getApplicationContext(),"On a pu cliquer",Toast.LENGTH_SHORT).show();

                for(BluetoothDevice identite : pairedDevices){
                    if(identite.getName().equals(textView.getText())){
                        device=identite;
                        Toast.makeText(getApplicationContext(),"Le periphérique distant a ete retrouve",Toast.LENGTH_SHORT).show();
                        client=new ConnectedAsClientThread(device,getApplicationContext(),bluetoothAdapter,getApplication());
                        break;
                    }

                }
                client.start();
            }
        });
    }

