    private void showBuildingLibraryProgress() {

        //Disables swiping events on the pager.
        welcomeViewPager.setCurrentItem(5);
        welcomeViewPager.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }

        });

        //Fade out the ViewPager indicator.
        Animation fadeOutAnim = AnimationUtils.loadAnimation(mContext, R.anim.fade_out);
        fadeOutAnim.setDuration(600);
        fadeOutAnim.setAnimationListener(fadeOutListener);
        indicator.startAnimation(fadeOutAnim);

    }

