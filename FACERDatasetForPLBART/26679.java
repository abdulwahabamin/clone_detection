    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.city_search_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);
        mAdapter = new AddCityRecyclerViewAdapter(new ArrayList<GeoCity>(),
                        new AddCityRecyclerViewAdapter.AddCityRecyclerViewItemListener() {
            @Override
            public void onItemClick(GeoCity newCity) {
                OrmCity city = new OrmCity(newCity.getGeoNameId(),newCity.getName(),newCity.getAdminName1(),
                        newCity.getCountryName(), Double.parseDouble(newCity.getLat()),
                        Double.parseDouble(newCity.getLng()));
                localDataSource.saveCity(city);
                Intent intent = new Intent(AddCityActivity.this, CitiesActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });
    }

