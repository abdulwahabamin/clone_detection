        @Override
        public void run() {
            ++mSpecialWeatherNumSnow;
            if (mSpecialWeatherNumSnow <= mSpecialWeatherNumLimitSnow) {
                int screenHeight = DensityUtil.getScreenHeight(CityWeatherActivity.this);
                int screenWidth = DensityUtil.getScreenWidth(CityWeatherActivity.this);
                int fX = mRandom.nextInt(screenWidth);

                ImageView imageView = new ImageView(CityWeatherActivity.this);
                imageView.setVisibility(View.VISIBLE);
                if ((mSpecialWeatherNumSnow & 0x1) == 0) {
                    //imageView.setImageResource(mSnowIconLightId);
                    mPresenter.getImageViewSrc(imageView, mSnowIconLightId);
                } else {
                    //imageView.setImageResource(mSnowIconDarkId);
                    mPresenter.getImageViewSrc(imageView, mSnowIconDarkId);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(fX, 0, 0, 0);
                rlBackgroundView.addView(imageView, layoutParams);

                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", -100, screenHeight + 100);
                if ((mSpecialWeatherNumSnow & 0x1) == 0) {
                    animator.setDuration(mSpecialWeatherSpeedLimitSnow);
                } else {
                    animator.setDuration(mSpecialWeatherSpeedLimitSnow + RAIN_SPEED_OFFSET);
                }
                animator.setRepeatMode(ObjectAnimator.RESTART);
                animator.setRepeatCount(ObjectAnimator.INFINITE);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

                mHandler.postDelayed(snowProc, SNOW_GEN_INTERVAL);
            }
        }

