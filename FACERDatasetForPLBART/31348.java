        @Override
        public void onCompleted() {
            mView.hideLoading();
            mView.showCityNameEdit();
            String cityName = getCityName(mLocatedCityId);
            String curCityName = getCityName(mCurCityId);
            if (!TextUtils.isEmpty(cityName) && !TextUtils.isEmpty(curCityName)) {
                mView.setLocatedCityName(mView.getContext().getString(R.string.located_city) + cityName, mView.getContext().getString(R.string.cur_city) + curCityName);
                mView.showLocatedCityName();
            } else {
                mView.hideLocatedCityName();
            }
        }

