    public void getBackgroundImage(View view, int resId) {
        GetBitmapUseCase bitmapUseCase = mBitmapUsecases.get(resId);
        if (bitmapUseCase == null) {
            mBitmapUsecases.put(resId, new GetBitmapUseCase(mView.getContext().getApplicationContext(), resId));
        }
        bitmapUseCase = mBitmapUsecases.get(resId);
        if (bitmapUseCase != null) {
            bitmapUseCase.execute(new BitmapSubscriber(view, BitmapSubscriber.VIEW_TYPE_VIEW));
        }
    }

