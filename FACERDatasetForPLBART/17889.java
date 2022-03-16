    @Override
    public void onCreate(FragmentActivity activity) {
        Log.d(TAG, "onCreate:called");

        mContext = activity;

        mMediaBrowserManager.initMediaBrowser(activity);

        mQueueIndexUpdatedDisposable = mQueueIndexUpdatedSubject.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                if (!mMvpView.updateQueueIndex(integer)) {
                    updateQueue(mMediaBrowserManager.getMediaController().getQueue());
                }
            }
        });
    }

