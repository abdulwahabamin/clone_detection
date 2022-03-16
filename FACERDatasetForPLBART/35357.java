    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHandleCityName(CityNameMessage message) {

        String cityName = message.getCityName();
        mPresenter.showDialog(cityName,getActivity());
    }

