    @Override
    public void updateItem(CityInfoData data, int position) {
        mCityId = data.getCityId();

        mTvItemCityName.setText(data.getCityName());
        if (data.getInitial() != null) {
            mTvItemCityLetter.setVisibility(View.VISIBLE);
            mTvItemCityLetter.setText(data.getInitial());
        } else {
            mTvItemCityLetter.setVisibility(View.GONE);
        }
    }

