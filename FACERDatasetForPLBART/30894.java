    @Override
    protected Observable<BitmapCacheWrapper> buildUseCaseObservable() {
        return Observable.create(new Observable.OnSubscribe<BitmapCacheWrapper>() {
            @Override
            public void call(Subscriber<? super BitmapCacheWrapper> subscriber) {
                BitmapCacheWrapper bitmapCacheWrapper = (BitmapCacheWrapper)MemoryCacheManager.getInstance().getItemFromCache(String.valueOf(mResId));
                if (bitmapCacheWrapper == null) {
                    bitmapCacheWrapper = new BitmapCacheWrapper(mContext, mResId);
                    bitmapCacheWrapper.inflate();
                    MemoryCacheManager.getInstance().putItemToCache(String.valueOf(mResId), bitmapCacheWrapper);
                }

                subscriber.onNext(bitmapCacheWrapper);
                subscriber.onCompleted();
            }
        });
    }

