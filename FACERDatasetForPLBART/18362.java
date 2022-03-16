    /**
     * Slides away the GridView.
     */
    private void slideAwayGridView() {
        android.view.animation.TranslateAnimation animation = new
                         android.view.animation.TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                         Animation.RELATIVE_TO_SELF, 0.0f,
                         Animation.RELATIVE_TO_SELF, 0.0f,
                         Animation.RELATIVE_TO_SELF, 2.0f);

        animation.setDuration(400);
        animation.setInterpolator(new AccelerateInterpolator(2.0f));
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation arg0) {
                mGridView.setVisibility(View.INVISIBLE);
                BrowserSubGridActivity.super.onBackPressed();

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationStart(Animation arg0) {

            }

        });

        mGridView.startAnimation(animation);
    }

