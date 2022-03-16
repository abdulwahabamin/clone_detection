    @Override
    public void stop() {
        if (!mIsNetworkAvailable)
            return;

        mLocationClient.onDestroy();
        mUseCase.unsubscribe();
    }

