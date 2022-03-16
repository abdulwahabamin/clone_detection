        @Override
        public void run() {

            //Slide down the header image.
            mApp.getPicasso().load(mHeaderImagePath).into(mHeaderImage);

            TranslateAnimation slideDown = new TranslateAnimation(mHeaderLayout, 400, new DecelerateInterpolator(2.0f),
                                                                  View.VISIBLE, Animation.RELATIVE_TO_SELF,
                                                                  0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                                                                  Animation.RELATIVE_TO_SELF, -2.0f,
                                                                  Animation.RELATIVE_TO_SELF, 0.0f);

            slideDown.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                    mHeaderLayout.setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

            });

            slideDown.animate();
        }

