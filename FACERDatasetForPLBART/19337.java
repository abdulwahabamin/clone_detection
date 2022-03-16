    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        mContext = getActivity();
        mApp = (Common) mContext.getApplicationContext();

        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_playlist_pager_fill, container, false);
        mPosition = getArguments().getInt("POSITION");

        overflowIcon = (ImageView) mRootView.findViewById(R.id.now_playing_overflow_icon);
    	coverArt = (ImageView) mRootView.findViewById(R.id.coverArt);
        bottomDarkPatch = (RelativeLayout) mRootView.findViewById(R.id.bottomDarkPatch);
        songInfoLayout = (RelativeLayout) mRootView.findViewById(R.id.songInfoLayout);
        songNameTextView = (TextView) mRootView.findViewById(R.id.songName);
    	artistAlbumNameTextView = (TextView) mRootView.findViewById(R.id.artistAlbumName);
    	
    	mLyricsScrollView = (ScrollView) mRootView.findViewById(R.id.lyrics_scroll_view);
    	mLyricsTextView = (TextView) mRootView.findViewById(R.id.lyrics);
    	mLyricsEmptyTextView = (TextView) mRootView.findViewById(R.id.lyrics_empty);
        
    	mLyricsTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
    	mLyricsEmptyTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
    	songNameTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
    	artistAlbumNameTextView.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));

        //Allow the TextViews to scroll if they extend beyond the layout margins.
        songNameTextView.setSelected(true);
        artistAlbumNameTextView.setSelected(true);
    	
    	//Initialize the pop up menu.
    	popup = new PopupMenu(getActivity(), overflowIcon);
		popup.getMenuInflater().inflate(R.menu.now_playing_overflow_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(menuItemClickListener);

        mSongHelper = new SongHelper();
        mSongHelper.setAlbumArtLoadedListener(this);

        if (mApp.getOrientation()==Common.ORIENTATION_LANDSCAPE)
            mSongHelper.populateSongData(mContext, mPosition);
		else
            mSongHelper.populateSongData(mContext, mPosition, new PicassoMirrorReflectionTransformer());

    	songNameTextView.setText(mSongHelper.getTitle());
    	artistAlbumNameTextView.setText(mSongHelper.getAlbum() + " - " + mSongHelper.getArtist());
        overflowIcon.setOnClickListener(overflowClickListener);

        //Kitkat padding.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int navigationBarHeight = Common.getNavigationBarHeight(mContext);
            int bottomPadding = songInfoLayout.getPaddingBottom();
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) bottomDarkPatch.getLayoutParams();

            if (navigationBarHeight > 0) {
                /* The nav bar already has padding, so remove the extra 15dp
                 * padding that was applied in the layout file.
                 */
                int marginPixelsValue = (int) mApp.convertDpToPixels(15, mContext);
                bottomPadding -= marginPixelsValue;
                params.height -= marginPixelsValue;
            }

            bottomPadding += navigationBarHeight;
            songInfoLayout.setPadding(0, 0, 0, bottomPadding);

            params.height += navigationBarHeight;
            bottomDarkPatch.setLayoutParams(params);

        }
    	
        return mRootView;
    }

