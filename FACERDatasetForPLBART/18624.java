    /**
     * Animates the pause button to a play button.
     */
    private void animatePauseToPlay() {

        //Check to make sure the current icon is the pause icon.
        if (mPlayPauseButton.getId()!=R.drawable.pause_light)
            return;

        //Scale out the pause button.
        final ScaleAnimation scaleOut = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f,
                mPlayPauseButton.getWidth()/2,
                mPlayPauseButton.getHeight()/2);
        scaleOut.setDuration(150);
        scaleOut.setInterpolator(new AccelerateInterpolator());


        //Scale in the play button.
        final ScaleAnimation scaleIn = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                mPlayPauseButton.getWidth()/2,
                mPlayPauseButton.getHeight()/2);
        scaleIn.setDuration(150);
        scaleIn.setInterpolator(new DecelerateInterpolator());

        scaleOut.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mPlayPauseButton.setImageResource(R.drawable.play_light);
                mPlayPauseButton.setPadding(0, 0, -5, 0);
                mPlayPauseButton.startAnimation(scaleIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

        scaleIn.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mPlayPauseButton.setScaleX(1.0f);
                mPlayPauseButton.setScaleY(1.0f);
                mPlayPauseButton.setId(R.drawable.play_light);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

        mPlayPauseButton.startAnimation(scaleOut);
    }

