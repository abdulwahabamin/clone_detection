    private void BindingView() {
        mActivity_bg_image = (ImageView) findViewById(R.id.bg_image);
        mActivity_bg_image1 = (ImageView) findViewById(R.id.bg_image1);

        mRoot = (RelativeLayout) findViewById(R.id.root);

        mRootofList= (RelativeLayout) findViewById(R.id.rootoflist);

        mBothmusicPlayer = (RelativeLayout) findViewById(R.id.bothmusicplayer);

        mAdView= (AdView) findViewById(R.id.adView_ma);
        mContentArea= (RelativeLayout) findViewById(R.id.contentarea);

        mMiniMusicPlayer = (LinearLayout) mBothmusicPlayer.findViewById(R.id.minimusicplayer);
        mMiniPlay = (RelativeLayout) mMiniMusicPlayer.findViewById(R.id.play);
        mMiniPause= (RelativeLayout) mMiniMusicPlayer.findViewById(R.id.pause);
        mMiniNext = (RelativeLayout) mMiniMusicPlayer.findViewById(R.id.next);
        mMiniPrevious = (RelativeLayout) mMiniMusicPlayer.findViewById(R.id.previous);
        mMiniSongName = (TextView) mMiniMusicPlayer.findViewById(R.id.songname);
        mMiniProgressBar = (ProgressBar) mMiniMusicPlayer.findViewById(R.id.progressBar);
        mMiniArtistAlbum= (TextView) mMiniMusicPlayer.findViewById(R.id.artist_album_name);
        mMiniAlbumArt= (ImageView) mMiniMusicPlayer.findViewById(R.id.album_art);
        mMiniAlbumArt1= (ImageView) mMiniMusicPlayer.findViewById(R.id.album_art1);

        mMusicPlayer = (RelativeLayout) mBothmusicPlayer.findViewById(R.id.musicplayer);
        mSongName= (TextView) mMusicPlayer.findViewById(R.id.songname);
        mArtistAlbum= (TextView) mMusicPlayer.findViewById(R.id.artist_album_name);
        mPlay= (RelativeLayout) mMusicPlayer.findViewById(R.id.play);
        mPause= (RelativeLayout) mMusicPlayer.findViewById(R.id.pause);
        mPrevious= (RelativeLayout) mMusicPlayer.findViewById(R.id.previous);
        mNext= (RelativeLayout) mMusicPlayer.findViewById(R.id.next);
        mMiniPlayer_inner= (RelativeLayout) mMiniMusicPlayer.findViewById(R.id.miniplayer_inner);

        mGoDown= (ImageView) mMusicPlayer.findViewById(R.id.godown);
        mControl_bg= (ImageView) mMusicPlayer.findViewById(R.id.control_bg);
        mControl_bg1= (ImageView) mMusicPlayer.findViewById(R.id.control_bg1);
        mMPSeekBar= (SeekBar) mMusicPlayer.findViewById(R.id.seekbar);

        mAlbumArt = (ImageView) mMusicPlayer.findViewById(R.id.album_art);
        mAlbumArt1= (ImageView) mMusicPlayer.findViewById(R.id.album_art1);
        mAlbumArt_Area = (RelativeLayout) mMusicPlayer.findViewById(R.id.album_art_area);

        mPresentTime = (TextView) mMusicPlayer.findViewById(R.id.present_time);
        mTotalTime = (TextView) mMusicPlayer.findViewById(R.id.total_time);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mFastScroller = (VerticalRecyclerViewFastScroller) findViewById(R.id.fast_scroller);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);

    }

