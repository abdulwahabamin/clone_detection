    @Provides
    @Singleton
    @ApplicationContext
    Context getContext() {
        return this.mApplication;
    }

