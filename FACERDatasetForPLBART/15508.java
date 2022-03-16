    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.audio_player, container, false);
        
        mTotalTime = (TextView)root.findViewById(R.id.audio_player_total_time);
        mCurrentTime = (TextView)root.findViewById(R.id.audio_player_current_time);

        mRepeat = (ImageButton)root.findViewById(R.id.audio_player_repeat);
        mPrev = (RepeatingImageButton)root.findViewById(R.id.audio_player_prev);
        mPlay = (ImageButton)root.findViewById(R.id.audio_player_play);
        mNext = (RepeatingImageButton)root.findViewById(R.id.audio_player_next);
        mShuffle = (ImageButton)root.findViewById(R.id.audio_player_shuffle);

        mRepeat.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                cycleRepeat();
            }
        });

        mPrev.setRepeatListener(mRewListener, 260);
        mPrev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MusicUtils.mService == null)
                    return;
                try {
                    if (MusicUtils.mService.position() < 2000) {
                        MusicUtils.mService.prev();
                    } else {
                        MusicUtils.mService.seek(0);
                        MusicUtils.mService.play();
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        mPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                doPauseResume();
            }
        });
        
        mNext.setRepeatListener(mFfwdListener, 260);
        mNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MusicUtils.mService == null)
                    return;
                try {
                    MusicUtils.mService.next();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        mShuffle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleShuffle();
            }
        });
        
        mProgress = (SeekBar)root.findViewById(android.R.id.progress);
        if (mProgress instanceof SeekBar) {
            SeekBar seeker = mProgress;
            seeker.setOnSeekBarChangeListener(mSeekListener);
        }
        mProgress.setMax(1000);
        
        mAlbumArtPager = (ViewPager)root.findViewById(R.id.now_playing_viewpager);
        mPagerAdapter = new AlbumArtPagerAdapter(getChildFragmentManager());
        mPagerAdapter.addFragment(new AlbumArtFragment());
        mPagerAdapter.addFragment(new AlbumArtFragment());
        mPagerAdapter.addFragment(new AlbumArtFragment());
        mAlbumArtPager.setAdapter(mPagerAdapter);
        mAlbumArtPager.setOffscreenPageLimit(3);
        mAlbumArtPager.setCurrentItem(1);
        mAlbumArtPager.setOnPageChangeListener(new AlbumArtPageListener());
        
        FrameLayout mColorstripBottom = (FrameLayout)root.findViewById(R.id.colorstrip_bottom);
        mColorstripBottom.setBackgroundColor(getResources().getColor(R.color.holo_blue_dark));
        return root;
    }

