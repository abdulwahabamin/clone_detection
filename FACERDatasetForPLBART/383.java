    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil);

        creer=(ImageView)findViewById(R.id.creer);
        joindre=(ImageView)findViewById(R.id.joindre);

        final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Votre périphérique ne supporte pas le bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if (!bluetoothAdapter.isEnabled()) {
                Intent bluetoothIntent = new Intent(bluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(bluetoothIntent, REQUEST_ENABLE_BT);
            }
        }

        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discorverIntent= new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discorverIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,5000);
                startActivity(discorverIntent);

                //On va créer le serveur
                serveur=new ConnectedAsServerThread(bluetoothAdapter,getApplicationContext(),getApplication());
                serveur.start();

                //Le broadcast
                //Le broadcast du serveur
                boundBroadCast= new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String action= intent.getAction();

                        if(BluetoothDevice.ACTION_ACL_CONNECTED.equals(action)){
                            Toast.makeText(getApplicationContext(),"Vous avez été joints.",Toast.LENGTH_LONG).show();
                            BluetoothSocket serveurSocket=null;
                            //On recupère le canal de connexion
                            try{
                                serveurSocket= serveur.getSocket();
                            }catch(Exception e){
                                Toast.makeText(getApplicationContext(),"On n'a pas recupéré le socket",Toast.LENGTH_SHORT).show();
                            }
                            //Rendre global le socket récupéré s'il n'est pas nul et lancer l'activité de jeu GoActivity

                            if(serveurSocket==null) Toast.makeText(getApplicationContext(),"Le socket est null",Toast.LENGTH_SHORT).show();
                            ((MyApplication)getApplication()).setServeurSocket(serveurSocket);
                            Intent intent1= new Intent(getApplicationContext(),GoActivity.class);
                            intent1.putExtra("statut","serveur");
                            startActivity(intent1);

                        }
                    }
                };

            }
        });

        joindre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        Button boite=(Button) findViewById(R.id.boite);
        boite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Boite_de_reception.class));
            }
        });
    }

