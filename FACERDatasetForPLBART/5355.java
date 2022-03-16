    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        progressBar=findViewById(R.id.progress);
        searchRecyclerView=findViewById(R.id.searchRecycler);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        back=findViewById(R.id.back);
        back.setOnClickListener(view -> {
            onBackPressed();
        });
        errorText=findViewById(R.id.errorText);
        fileEx=FileEx.newFileManager(Environment.getExternalStorageDirectory().toString(),this);
        handleIntent(getIntent());
    }

