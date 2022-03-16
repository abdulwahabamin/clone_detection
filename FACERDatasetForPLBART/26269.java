    public void initViews() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mHotCityAdapter = new BaseRecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mHotCityAdapter);

        City locatedCity = CoreManager.getImpl(ILocationApi.class).getLocatedCity();
        showLocation(locatedCity!=null);

    }

