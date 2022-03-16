    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_city);

        mACache = ACache.get(getApplicationContext());
        mCityList = (ArrayList<CityInfo>) mACache.getAsObject(Extras.CITY_LIST);
        adapter = new RAdapter<>(mCityList, new RSingleDelegate<>(ManageCityViewHolder.class));
        adapter.setTag(mACache);
        rvCity.setLayoutManager(new LinearLayoutManager(rvCity.getContext()));
        rvCity.setAdapter(adapter);
        fabAdd.setOnClickListener(this);
    }

