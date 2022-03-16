    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mAdapter = new HoursRecyclerViewAdapter(getActivity(), new ArrayList<OrmWeather>());
        mAdapter.setListener(new HoursRecyclerViewAdapter.OnIconClickListener() {
            @Override
            public void onIconClick(OrmWeather weather, View view) {
                Toast.makeText(getActivity(),weather.getCondition_text(),Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(mAdapter);
        mAdapter.clear();
        mAdapter.notifyDataSetChanged();
    }

