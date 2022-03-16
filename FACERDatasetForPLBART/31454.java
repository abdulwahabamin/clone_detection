    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        mAdapter = new CitiesCandidatesApdapter(this.getApplicationContext(), R.layout.ll_cities_candidates_item, mCandidates);
        lvCandidates.setAdapter(mAdapter);
    }

