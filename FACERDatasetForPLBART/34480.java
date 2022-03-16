    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        SearchView searchBox = (SearchView) findViewById(R.id.search_box);
        assert searchBox != null;
        searchBox.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                if(newText != null && newText.trim().length() > 1){
                    MyApplication.getInstance().getWeatherService().searchCities(newText.trim(), new Action1<List<CityData>>() {
                        @Override
                        public void call(final List<CityData> cityDatas) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.setResult(cityDatas);
                                }
                            });
                        }
                    });
                }else{
                    adapter.removeAll();
                }
                return false;
            }
        });

        resultCities = (ListView) findViewById(R.id.search_result);
        adapter = new SearchResultAdapter();
        resultCities.setAdapter(adapter);
        resultCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CityData cityData = (CityData) parent.getItemAtPosition(position);
                //Log.d("weather", cityData.toString());
                Intent intent = new Intent();
                intent.putExtra(MainActivity.SEARCH_CITY_KEY, cityData.city_id);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

