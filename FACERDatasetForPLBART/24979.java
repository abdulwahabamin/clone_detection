    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        setupSearchView(searchView);

        searchList = (RecyclerView) findViewById(R.id.search_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        searchList.setLayoutManager(layoutManager);
        List<SearchResult> results = MusicDataUtility.getAllSearchResults(getApplicationContext());
        if(results != null && results.size() > 0){
            searchList.setAdapter(new SearchAdapter(results));
            findViewById(R.id.no_search_results).setVisibility(View.GONE);
        } else {
            findViewById(R.id.no_search_results).setVisibility(View.VISIBLE);
        }

    }

