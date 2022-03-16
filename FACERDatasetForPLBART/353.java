    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        String adresseMAC= getIntent().getStringExtra("MAC");

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

        msgList=(RecyclerView) findViewById(R.id.recyclerView);

        msgList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MessageRecyclerAdapter adapter= new MessageRecyclerAdapter();

        Cursor cursor= db.getAllMessageForMAc(adresseMAC);
        while (cursor.moveToNext()){
            if(cursor.getString(2).equals("moi")){
                adapter.addMessage(new com.apk.franckadjibao.bluetoothtry.Message(1,cursor.getString(1),cursor.getString(3)));
            }else{
                adapter.addMessage(new com.apk.franckadjibao.bluetoothtry.Message(2,cursor.getString(1),cursor.getString(3)));
            }
        }

        msgList.setAdapter(adapter);
        msgList.hasFixedSize();
    }

