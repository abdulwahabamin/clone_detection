    private void initViews() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mLifeAdapter = new BaseRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mLifeAdapter);
        mLifeAdapter.registerHolder(LifeItemHolder.class, R.layout.weather_item_life_index);
    }

