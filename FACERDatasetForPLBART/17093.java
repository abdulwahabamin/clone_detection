    @Provides
    @Singleton
    @Named(PROVIDER_QUEUE_INDEX_UPDATED)
    PublishSubject<Integer> getQueueIndexUpdatedProvider() {
        return PublishSubject.create();
    }

