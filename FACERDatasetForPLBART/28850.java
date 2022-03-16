    public void setAdapter(CityWeatherAdapter adapter) {
        mAdapter = adapter;

        if(recyclerView != null) {
            recyclerView.setAdapter(mAdapter);
        }
    }

