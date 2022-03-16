    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	mContext = getApplicationContext();
    	mApp = (Common) getApplicationContext();
    	mApp.setNowPlayingActivity(this);
    	setNowPlayingActivityListener(mApp.getPlaybackKickstarter());
        mFadeInAnimation = AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_top);
        mFadeInAnimation.setDuration(700);
    	
    	//Set the UI theme.
        setTheme();
        
        super.onCreate(savedInstanceState);	
    	setContentView(R.layout.activity_now_playing);
    	
    	//Set the volume stream for this activity.
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        
        //Drawer layout.
        if (!mApp.isTabletInLandscape()) {
            mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_drawer_root);
            mDrawerParentLayout = (FrameLayout) findViewById(R.id.now_playing_drawer_frame_root);
            mCurrentQueueLayout = (RelativeLayout) findViewById(R.id.queue_drawer);
            mDrawerLayout.setDrawerListener(mDrawerListener);
            mDrawerLayout.setBackgroundColor(UIElementsHelper.getBackgroundColor(mContext));

        } else {
            mCurrentQueueLayout = (RelativeLayout) findViewById(R.id.queue_drawer);
        }
        
        //ViewPager.
        mViewPager = (VelocityViewPager) findViewById(R.id.nowPlayingPlaylistPager);

        //Seekbar indicator.
        mSeekbarIndicatorLayoutParent = (RelativeLayout) findViewById(R.id.seekbarIndicatorParent);
        mSeekbarIndicatorLayout = (RelativeLayout) findViewById(R.id.seekbarIndicator);
        mSeekbarIndicatorText = (TextView) findViewById(R.id.seekbarIndicatorText);

        mSeekbarIndicatorLayoutParent.setVisibility(View.GONE);
        mSeekbarIndicatorLayout.setBackgroundResource(UIElementsHelper.getGridViewCardBackground(mContext));
        mSeekbarIndicatorText.setTypeface(TypefaceHelper.getTypeface(mContext, "Roboto-Regular"));
        mSeekbarIndicatorText.setTextColor(UIElementsHelper.getThemeBasedTextColor(mContext));
    	
    	//Playback Controls.
        mControlsLayoutHeaderParent = (RelativeLayout) findViewById(R.id.now_playing_controls_header_parent);
        mControlsLayoutHeader = (RelativeLayout) findViewById(R.id.now_playing_controls_header);
        mPlayPauseButtonBackground = (RelativeLayout) findViewById(R.id.playPauseButtonBackground);
    	mPlayPauseButton = (ImageButton) findViewById(R.id.playPauseButton);
        mNextButton = (ImageButton) findViewById(R.id.nextButton);
    	mPreviousButton = (ImageButton) findViewById(R.id.previousButton);
    	mShuffleButton = (ImageButton) findViewById(R.id.shuffleButton);
    	mRepeatButton = (ImageButton) findViewById(R.id.repeatButton);

    	//Song info/seekbar elements.
    	mSeekbar = (SeekBar) findViewById(R.id.nowPlayingSeekBar);
    	mStreamingProgressBar = (ProgressBar) findViewById(R.id.startingStreamProgressBar);
    	mStreamingProgressBar.setVisibility(View.GONE);

    	try {
    		mSeekbar.setThumb(getResources().getDrawable(R.drawable.transparent_drawable));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

        mPlayPauseButtonBackground.setBackgroundResource(UIElementsHelper.getShadowedCircle(mContext));
        mPlayPauseButton.setImageResource(R.drawable.pause_light);
        mPlayPauseButton.setId(R.drawable.pause_light);
    	mNextButton.setImageResource(UIElementsHelper.getIcon(mContext, "btn_playback_next"));
    	mPreviousButton.setImageResource(UIElementsHelper.getIcon(mContext, "btn_playback_previous"));
    	
    	if (mApp.getCurrentTheme()==Common.DARK_THEME) {
    		mNextButton.setAlpha(1f);
    		mPreviousButton.setAlpha(1f);
        }

        //KitKat specific layout code.
        setKitKatTranslucentBars();

    	//Set the control buttons and background.
        setControlButtonsBackground();
    	setPlayPauseButton();
        setShuffleButtonIcon();
        setRepeatButtonIcon();
    	
        //Set the click listeners.
    	mSeekbar.setOnSeekBarChangeListener(seekBarChangeListener);
    	mNextButton.setOnClickListener(mOnClickNextListener);
    	mPreviousButton.setOnClickListener(mOnClickPreviousListener);
    	mPlayPauseButton.setOnClickListener(playPauseClickListener);
        mPlayPauseButtonBackground.setOnClickListener(playPauseClickListener);
    	mShuffleButton.setOnClickListener(shuffleButtonClickListener);
    	mRepeatButton.setOnClickListener(repeatButtonClickListener);

        //Apply haptic feedback to the play/pause button.
        mPlayPauseButtonBackground.setHapticFeedbackEnabled(true);
        mPlayPauseButton.setHapticFeedbackEnabled(true);

    }

