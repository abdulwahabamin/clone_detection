    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (RecyclerView)findViewById(R.id.myList);
        myList.setHasFixedSize(true);
        myList.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();

        for(int i =0; i<=20; i++){
            ModelForListItem item = new ModelForListItem("Heading", "description");
            items.add(item);
        }

        adapter = new Adapter(items, this);
        myList.setAdapter(adapter);
    }

