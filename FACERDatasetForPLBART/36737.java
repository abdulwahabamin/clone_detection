    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ButterKnife.bind(this);

        mCountyInput.setText(getString(R.string.loading_county_list));
        mCountyInput.setEnabled(false);

        mCountyList = new ArrayList<>();
        mCountyStringList = new ArrayList<>();
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        mCountyInput.setAdapter(mAdapter);
    }

