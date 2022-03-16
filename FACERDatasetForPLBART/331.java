    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boite_de_reception);

        db=new MessageDB(getApplicationContext());
        listView=(ListView)findViewById(R.id.listView);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Boite de réception");
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.left_arrow));
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

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

        //Recupérer toutes les adresses MAC
        Cursor cursor= db.getAdresseMACs();
        ArrayList<String> listMAC= new ArrayList<String>();
        ArrayList<String> listIntitule= new ArrayList<String>();
        ArrayList<String> listNom= new ArrayList<String>();

        String adressMAC;
        while(cursor.moveToNext()){
        adressMAC=cursor.getString(0);
        listMAC.add(adressMAC);
        Cursor c= db.getInfoWithMAc(adressMAC);
        Cursor c1=db.getRemoteDeviceName(adressMAC);
            //Pour chaque nom on prend le dernier message et le dernier nom
            if(c.moveToNext() && c1.moveToNext()){
                listIntitule.add(c.getString(1));
                listNom.add(c1.getString(0));
            }
            c.close();
            c1.close();
        }
        cursor.close();


        ArrayAdapter adapter= new MessageFileAdapter(getApplicationContext(),listNom,listIntitule,listMAC);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(getApplicationContext(), FileActivity.class);
                String macadress= ((TextView)view.findViewById(R.id.macadress)).getText().toString();
                i.putExtra("MAC",macadress);
                startActivity(i);
            }
        });
    }

