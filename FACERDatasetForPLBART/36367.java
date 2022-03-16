    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_drawer_menu, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        Context context = rootView.getContext();
        if (columnCount <= 1) {
            cityManagerRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            cityManagerRecyclerView.setLayoutManager(new GridLayoutManager(context, columnCount));
        }
        cityManagerRecyclerView.setItemAnimator(new DefaultItemAnimator());
        weatherList = new ArrayList<>();
        cityManagerAdapter = new CityManagerAdapter(weatherList);
        cityManagerAdapter.setOnItemClickListener(new CityManagerAdapter.OnCityManagerItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    presenter.saveCurrentCityToPreference(weatherList.get(position).getCityId());
                    onSelectCity.onSelect(weatherList.get(position).getCityId());
                } catch (InvalidClassException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDeleteClick(String cityId) {
                presenter.deleteCity(cityId);
            }
        });
        cityManagerRecyclerView.setAdapter(cityManagerAdapter);

        presenter.subscribe();

        return rootView;
    }

