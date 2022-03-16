    @Override
    public void onTabClickOnSamePage(int position) {
        Log.d(TAG, "onTabClickOnSamePage:clicked");
        switch (position) {
            case 0:
                mAllSongsScrollToTopSubject.onNext(0);
                break;
            case 1:
                mAlbumsScrollToTopSubject.onNext(0);
                break;
            case 2:
                mArtistsScrollToTopSubject.onNext(0);
                break;
            case 3:
                mPlaylistsScrollToTopSubject.onNext(0);
        }
    }

