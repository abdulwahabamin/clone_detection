    @Override
    public void destroy() {
        mUseCase.clear();
        mUseCase = null;
        for (int index = 0; index != mBitmapUsecases.size(); ++index) {
            GetBitmapUseCase bitmapUseCase = mBitmapUsecases.valueAt(index);
            if (bitmapUseCase != null) {
                bitmapUseCase.clear();
            }
        }
        mBitmapUsecases.clear();
        mBitmapUsecases = null;
        mView = null;
    }

