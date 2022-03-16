    /**
     * Initializes the view pager.
     */
    private void initViewPager() {

        try {
            mViewPager.setVisibility(View.INVISIBLE);
            mViewPagerAdapter = new PlaylistPagerAdapter(getSupportFragmentManager());
            mViewPager.setAdapter(mViewPagerAdapter);
            mViewPager.setOffscreenPageLimit(0);
            mViewPager.setOnPageChangeListener(mPageChangeListener);
            mViewPager.setCurrentItem(mApp.getService().getCurrentSongIndex(), false);

            FadeAnimation fadeAnimation = new FadeAnimation(mViewPager, 600, 0.0f,
                                                            1.0f, new DecelerateInterpolator(2.0f));

            fadeAnimation.animate();

        } catch (IllegalStateException e) {
            /*
             * Catches any exceptions that may occur
             * as a result of the user rapidly changing
             * their device's orientation.
             */
        }

        //Delay loading extra fragments by 1000ms.
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                mViewPager.setOffscreenPageLimit(10);
            }

        }, 1000);

    }

