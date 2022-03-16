    @Override
    public void initViews() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);

        mWeatherItemList.setLayoutManager(linearLayoutManager);
        mWeatherItemList.setBackgroundResource(R.color.dark_background);
        mMoreInfoAdapter = new BaseRecyclerAdapter(mActivity);
    }

