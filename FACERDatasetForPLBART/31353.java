    public void setCityId(String cityId) {
        mCityId = cityId;
        mView.updateUpdateService(mCityId);
        if (mUseCase != null) {
            mUseCase.setCityId(mCityId);
        }
    }

