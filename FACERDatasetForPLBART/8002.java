    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ListAdapter(ROOT);
        mCurrentDirView = (TextView) findViewById(R.id.current_dir_view);
        mCurrentDirView.setText(mAdapter.getCurrentDirectory());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.file_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        registerForContextMenu(recyclerView);
    }

