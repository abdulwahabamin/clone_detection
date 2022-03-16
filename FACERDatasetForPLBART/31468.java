    @Override
    public void showLocatedCityName() {
        if (mLocateCityId != null && mIsLocateSucceeded && mCurCityId != null) {
            llLocated.setVisibility(View.VISIBLE);
        }
    }

