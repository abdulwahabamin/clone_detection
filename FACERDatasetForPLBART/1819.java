    private void init() {


        startService(new Intent(this, CleanUpService.class));

        getSupportActionBar().setTitle("Chats");
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        ll_empty= (LinearLayout) findViewById(R.id.ll_empty);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);

        Log.d(TAG, "setUpList: cadapter");

        list=new ArrayList<>();
        list.addAll(RealmManager.getAllStoredContacts().findAll());

        cAdapter=new ContactsAdapter(this,list,this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);
    }

