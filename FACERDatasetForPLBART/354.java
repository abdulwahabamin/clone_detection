    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        Toolbar toolBar=(Toolbar)findViewById(R.id.toolbar);
        toolBar.setLogo(R.drawable.icone);
        toolBar.setTitle(getResources().getString(R.string.app_name));

        //La base de données
        db=new MessageDB(getApplicationContext());
        try{
            db.createDataBase();
        }catch(Exception e){
            throw new Error("Erreur à la création de la base de données");
        }
        try{
            db.openDataBase();
        }catch(Exception e){
            e.printStackTrace();
        }

        msgList=(RecyclerView) findViewById(R.id.messageList);
        message=(EditText)findViewById(R.id.textMessage);
        envoyer=(FloatingActionButton) findViewById(R.id.sendMsg);

        msgList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final MessageRecyclerAdapter adapter= new MessageRecyclerAdapter();
        msgList.setAdapter(adapter);
        msgList.hasFixedSize();


        //Le handler qui gère mon affichage Mr Franck Adjibao Akintola Lonlon
        Handler mHandler= new Handler(){
            BluetoothSocket socket;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                String statut= getIntent().getExtras().getString("statut");
                if(statut.equals("client")){
                    socket=((MyApplication)getApplication()).getClientSocket();
                }else{
                    socket=((MyApplication)getApplication()).getServeurSocket();
                }
                switch (msg.what){
                    case 1:
                        date=new Date();
                        adapter.addMessage(new com.apk.franckadjibao.bluetoothtry.Message(1,msg.obj.toString(),""+date));
                        db.insertMessage(msg.obj.toString(),"moi",socket.getRemoteDevice().getAddress());
                        break;
                    case 2:
                        date=new Date();
                        String msgEnvoye=new String((byte[])msg.obj,0,msg.arg1);
                        adapter.addMessage(new com.apk.franckadjibao.bluetoothtry.Message(2,msgEnvoye,""+date));
                        db.insertMessage(msgEnvoye,socket.getRemoteDevice().getName(),socket.getRemoteDevice().getAddress());
                        break;
                }
            }
        };


        //Savoir s'il s'agit d'un client ou d'un serveur
        String statut= getIntent().getExtras().getString("statut");
        if(statut.equals("client")){
            BluetoothSocket socket=((MyApplication)getApplication()).getClientSocket();
            manager= new ManageConnectionThread(socket,getApplicationContext(),mHandler);

            if(socket==null) Toast.makeText(getApplicationContext(),"socket client nul",Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(),"Réussi côté client",Toast.LENGTH_SHORT).show();

        }else if(statut.equals("serveur")){
            try{
                BluetoothSocket socket=((MyApplication)getApplication()).getServeurSocket();
                //Comment
                manager= new ManageConnectionThread(socket,getApplicationContext(),mHandler);
                if(socket==null) Toast.makeText(getApplicationContext(),"socket serveur nul",Toast.LENGTH_SHORT).show();

                else Toast.makeText(getApplicationContext(),"Réussi côté serveur",Toast.LENGTH_SHORT).show();

            }catch (Exception e1){
                Toast.makeText(getApplicationContext(),"Socket non récupéré",Toast.LENGTH_LONG).show();
            }

        }
        manager.start();

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgString=message.getText().toString();
                manager.write(msgString);
                message.setText("");
                Toast.makeText(getApplicationContext(),"Message envoyé",Toast.LENGTH_SHORT).show();
            }
        });
    }

