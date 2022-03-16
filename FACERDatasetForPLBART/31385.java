    private void locateFailed() {
        if (mIsFirstStartup && mView != null) {
            mView.navigateToCitiesActivity(mDefaultCityId, false, mDefaultCityId);
        }
        else {
            if (mView != null)
                mView.navigateToCityWeatherActivity(mDefaultCityId);
        }
    }

