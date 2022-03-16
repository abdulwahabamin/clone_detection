    @Override
    public void destroy() {
        if (mCities != null) {
            mCities.clear();
        }
        mCandidates.clear();
        mUseCase.clear();
        mBitmapUsecases.clear();
    }

