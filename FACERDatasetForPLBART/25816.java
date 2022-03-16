    @Override
    public void initViews() {

        if (TimeUtil.isNight()) {
            mMainBgIv.setBackgroundResource(R.mipmap.weather_bg_night);
        }else {
            mMainBgIv.setBackgroundResource(R.mipmap.weather_bg_day);
        }

        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(null);
        getSupportActionBar().setTitle("");
        mAppBarLayout.addOnOffsetChangedListener(this);
        setupViewPager();
        setupHoursForecast();
        mTitleContainer.post(new Runnable() {
            @Override
            public void run() {
                mWeatherInfoContainerLeft = mTitleContainer.getX();
                percentageOfShowTitle = (mTitleContainer.getBottom()) * 1.0f / mAppBarLayout.getTotalScrollRange();
                if (percentageOfShowTitle == 0) {
                    mWeatherInfoContainerLeft = DEFAULT_PERCENTAGE;
                }
            }
        });
        mActionRotate = ObjectAnimator.ofFloat(mRefreshStatus, "rotation", 0, 360);
        mActionRotate.setDuration(ROTATION_DURATION);
        mActionRotate.setRepeatCount(-1);

        mDrawableLocation = UIUtil.getDrawable(this, R.mipmap.core_location);
        mDrawableLocation.setBounds(0, 0, UIUtil.dipToPx(this, R.dimen.common_location_size), UIUtil.dipToPx(this, R.dimen.common_location_size));

        mSucceedAnimator = ofFloat(mPostTimeTv, "scaleX", 1, 0, 1).setDuration(POSTTIME_DURATION);
        mSucceedAnimator.setStartDelay(ROTATION_DURATION);


    }

