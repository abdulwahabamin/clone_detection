        @Override
        public void run() {
            ++mSpecialWeatherNumLightning;
            if (mSpecialWeatherNumLightning <= mSpecialWeatherNumLimitLightning) {
                int toolbarHeight = 0;
                int screenHeight = DensityUtil.getScreenHeight(CityWeatherActivity.this);
                int screenWidth = DensityUtil.getScreenWidth(CityWeatherActivity.this);

                ImageView imageView = new ImageView(CityWeatherActivity.this);
                imageView.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if ((mSpecialWeatherNumLightning & 0x1) == 0) {
                    //imageView.setImageResource(R.drawable.lightning_2);
                    mPresenter.getImageViewSrc(imageView, R.drawable.lightning_2);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    layoutParams.setMargins(0, toolbarHeight + mRandom.nextInt(screenHeight >> 2), screenWidth >> 2 + mRandom.nextInt(screenWidth >> 2), 0);
                } else {
                    //imageView.setImageResource(R.drawable.lightning_1);
                    mPresenter.getImageViewSrc(imageView, R.drawable.lightning_1);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    layoutParams.setMargins(mRandom.nextInt(screenWidth >> 2), toolbarHeight + mRandom.nextInt(screenHeight >> 2), 0, 0);
                }
                rlBackgroundView.addView(imageView, layoutParams);

                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 0, 1);
                animator.setDuration(LIGHTNING_SPEED_H);
                animator.setRepeatMode(ObjectAnimator.REVERSE);
                animator.setRepeatCount(3);
                animator.setInterpolator(new AccelerateInterpolator());
                animator.start();

                mHandler.postDelayed(lightningProc, LIGHTNING_GEN_INTERVAL + mRandom.nextInt(LIGHTNING_GEN_INTERVAL));
            } else {
                mSpecialWeatherNumLightning = 0;
                mHandler.postDelayed(lightningProc, LIGHTNING_GEN_INTERVAL + mRandom.nextInt(LIGHTNING_GEN_INTERVAL));
            }
        }

