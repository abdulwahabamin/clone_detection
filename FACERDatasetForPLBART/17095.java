    @Provides
    @Singleton
    @Named(PROVIDER_ALBUMS_SCROLL_TO_TOP)
    PublishSubject<Integer> getAlbumsScrollToTopProvider() {
        return PublishSubject.create();
    }

