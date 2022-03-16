    private void gotoNext() {
        if (!mIsNetworkAvailable && mView != null) {
            mView.showError(mView.getContext().getString(R.string.network_unavailable));
            mView.navigateToCityWeatherActivity(mDefaultCityId);
        } else if (mIsDownloadFinished && mIsLocateFinished) {
            if (!mIsDownloadSucceeded && mView != null) {
                mView.showError(mView.getContext().getString(R.string.server_unavailable));
                mView.navigateToCityWeatherActivity(mDefaultCityId);
            } else {
                if (!mIsLocateSucceeded || !getCityIdFromLocation()) {
                    locateFailed();
                } else {
                    locateSucceeded();
                }
            }
        }
    }

