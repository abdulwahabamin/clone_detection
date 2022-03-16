    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        presenter = new AddCityPresenter(new AddCityRepository(), this);
        adapter = new RAdapter<>(cityEntityList, new RSingleDelegate<>(AddCityViewHolder.class));
        adapter.setTag(presenter);
        rvCity.setLayoutManager(new LinearLayoutManager(rvCity.getContext()));
        rvCity.setAdapter(adapter);

        fabLocation.setOnClickListener(this);

        presenter.onCreate();
        presenter.showProvince();
    }

