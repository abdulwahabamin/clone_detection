    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTheme();
        setContentView(R.layout.testlayout);
        setupToolbar();
        setToolbarBackIcon();
        items = new ArrayList<>();
        downloadJSON();

        RecyclerView rvUsers = (RecyclerView) findViewById(R.id.rvUsers);
        adapter = new ForecastOverviewAdapter(this, getDays());
        rvUsers.setAdapter(adapter);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
    }

