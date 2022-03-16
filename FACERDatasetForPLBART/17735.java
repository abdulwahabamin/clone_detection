    @Override
    public void onCreate(FragmentActivity activity) {
        Log.d(TAG, "onCreate:called");
        mContext = activity;

        //init media browser
        mMediaBrowserManager.initMediaBrowser(activity);

        //check if media browser is already connected or not
        if (!mMediaBrowserManager.isMediaBrowserConnected()) {
            mMediaBrowserManager.connectMediaBrowser();
        }

        selectedItemDisposable = mSelectedItemPublishSubject.subscribe(new Consumer<MediaBrowserCompat.MediaItem>() {
            @Override
            public void accept(MediaBrowserCompat.MediaItem item) throws Exception {
                if (mMvpView.isSlidingUpPaneHidden()) {
                    mMvpView.setSlidingUpPaneCollapsed();
                }
            }
        });

        albumClickDisposable = mAlbumClickSubject.subscribe(new Consumer<Pair<MediaBrowserCompat.MediaItem, View>>() {
            @Override
            public void accept(Pair<MediaBrowserCompat.MediaItem, View> mediaItemViewPair) throws Exception {
                mMvpView.startAlbumFragment(mediaItemViewPair.first, mediaItemViewPair.second);
            }
        });

        artistClickDisposable = mArtistClickSubject.subscribe(new Consumer<MediaBrowserCompat.MediaItem>() {
            @Override
            public void accept(MediaBrowserCompat.MediaItem item) throws Exception {
                mMvpView.startArtistFragment(item);
            }
        });

        playlistClickDisposable = mPlaylistClickSubject.subscribe(new Consumer<Pair<MediaBrowserCompat.MediaItem, View>>() {
            @Override
            public void accept(Pair<MediaBrowserCompat.MediaItem, View> mediaItemViewPair) throws Exception {
                mMvpView.startPlaylistFragment(mediaItemViewPair.first, mediaItemViewPair.second);
            }
        });

        mMusicPlayerPanelDisposable = mMusicPlayerPanelPublishSubject.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                switch (integer) {
                    case -1:
                        mMvpView.isSlidingUpPaneHidden();
                        break;
                    case 0:
                        mMvpView.setSlidingUpPaneCollapsed();
                        break;
                    case 1:
                        mMvpView.setSlidingUpPaneExpanded();
                        break;
                }
            }
        });
    }

