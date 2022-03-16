    private void locateSucceeded() {
        if (mIsFirstStartup && mView != null) {
            mView.navigateToCitiesActivity(mCityId, true, mDefaultCityId);
        } else {
            if (mCityId.equalsIgnoreCase(mDefaultCityId) && mView != null) {
                mView.navigateToCityWeatherActivity(mCityId);
            } else {
                if (mView != null) {
                    mView.navigateToCitiesActivity(mCityId, true, mDefaultCityId);
                }
            }
        }
    }

