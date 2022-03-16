    @Provides
    @PerActivity
    @ActivityContext
    Context getContext() {
        return this.mContext;
    }

