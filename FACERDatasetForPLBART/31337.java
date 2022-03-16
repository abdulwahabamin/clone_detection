    @Override
    public void stop() {
        mUseCase.unsubscribe();
        for (int index = 0; index != mBitmapUsecases.size(); ++index) {
            GetBitmapUseCase bitmapUseCase = mBitmapUsecases.valueAt(index);
            if (bitmapUseCase != null) {
                bitmapUseCase.unsubscribe();
            }
        }
    }

