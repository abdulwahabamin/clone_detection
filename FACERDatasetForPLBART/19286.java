    /**
     * Slides in the controls bar from the bottom along with a
     * slight rotation.
     */
    private void animateInControlsBar() {
        android.view.animation.TranslateAnimation slideUp =
                new android.view.animation.TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                                                              Animation.RELATIVE_TO_SELF, 0.0f,
                                                              Animation.RELATIVE_TO_SELF, 2.0f,
                                                              Animation.RELATIVE_TO_SELF, 0.0f);
        slideUp.setDuration(300);
        slideUp.setInterpolator(new DecelerateInterpolator(2.0f));

        slideUp.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                mControlsLayoutHeaderParent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

        mControlsLayoutHeaderParent.startAnimation(slideUp);
    }

