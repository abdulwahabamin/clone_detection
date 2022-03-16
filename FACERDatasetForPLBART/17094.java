    @Provides
    @Singleton
    @Named(PROVIDER_ALL_SONGS_SCROLL_TO_TOP)
    PublishSubject<Integer> getAllSongsScrollToTopProvider() {
        return PublishSubject.create();
    }

