    @Provides
    @Singleton
    @Named(PROVIDER_ARTISTS_SCROLL_TO_TOP)
    PublishSubject<Integer> getArtistsScrollToTopProvider() {
        return PublishSubject.create();
    }

