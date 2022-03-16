    @SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		mContext = getActivity();
		mApp = (Common) mContext.getApplicationContext();

		View rootView = inflater.inflate(R.layout.fragment_queue_drawer, null);
		if (mApp.getCurrentTheme()==Common.LIGHT_THEME) {
			rootView.setBackgroundColor(0xFFFFFFFF);
		} else {
			rootView.setBackgroundColor(0xFF191919);
		}

        mMiniPlayerLayout = (RelativeLayout) rootView.findViewById(R.id.queue_drawer_mini_player_layout);
        mMiniPlayerAlbumArt = (ImageView) rootView.findViewById(R.id.queue_drawer_album_art);
        mPlayPauseBackground = (RelativeLayout) rootView.findViewById(R.id.playPauseButtonBackground);
        mPlayPauseButton = (ImageButton) rootView.findViewById(R.id.playPauseButton);
        mNextButton = (ImageButton) rootView.findViewById(R.id.nextButton);
        mPreviousButton = (ImageButton) rootView.findViewById(R.id.previousButton);
        mTitleText = (TextView) rootView.findViewById(R.id.songName);
        mSubText = (TextView) rootView.findViewById(R.id.artistAlbumName);
        mListView = (DragSortListView) rootView.findViewById(R.id.queue_drawer_list_view);
        mEmptyInfoText = (TextView) rootView.findViewById(R.id.queue_drawer_empty_text);

        mPlayPauseBackground.setBackgroundResource(UIElementsHelper.getShadowedCircle(mContext));
        mPlayPauseButton.setId(R.drawable.pause_light);

        mTitleText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mSubText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mEmptyInfoText.setTypeface(TypefaceHelper.getTypeface(getActivity(), "Roboto-Regular"));

        //Set the click listeners.
        mMiniPlayerLayout.setOnClickListener(mOnClickMiniPlayer);
        mPlayPauseBackground.setOnClickListener(playPauseClickListener);
        mPlayPauseButton.setOnClickListener(playPauseClickListener);
        mNextButton.setOnClickListener(mOnClickNextListener);
        mPreviousButton.setOnClickListener(mOnClickPreviousListener);

        //Restrict all touch events to this fragment.
        rootView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }

        });

        //KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int navBarHeight = Common.getNavigationBarHeight(mContext);
            if (mListView!=null) {
                mListView.setPadding(0, 0, 0, navBarHeight);
                mListView.setClipToPadding(false);
            }

        }

		return rootView;
	}

