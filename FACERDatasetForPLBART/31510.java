        @Override
        public void run() {
            ++mSpecialWeatherNumRain;
            if (mSpecialWeatherNumRain <= mSpecialWeatherNumLimitRain) {
                int screenHeight = DensityUtil.getScreenHeight(CityWeatherActivity.this);
                int screenWidth = DensityUtil.getScreenWidth(CityWeatherActivity.this);
                int fX = mRandom.nextInt(screenWidth << 1);
                int tX = fX - (int)(screenHeight * 0.58);

                ImageView imageView = new ImageView(CityWeatherActivity.this);
                imageView.setVisibility(View.VISIBLE);
                mPresenter.getImageViewSrc(imageView, mRainIconId);
                //imageView.setImageResource(mRainIconId);
                imageView.setRotation(30);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(fX, 0, 0, 0);
                rlBackgroundView.addView(imageView, layoutParams);

                PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat("translationY", -100, screenHeight + 100);
                PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat("translationX", fX, tX);
                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, holderX, holderY);
                if ((mSpecialWeatherNumRain & 0x1) == 0) {
                    animator.setDuration(mSpecialWeatherSpeedLimitRain);
                } else {
                    animator.setDuration(mSpecialWeatherSpeedLimitRain + RAIN_SPEED_OFFSET);
                }
                animator.setRepeatMode(ObjectAnimator.RESTART);
                animator.setRepeatCount(ObjectAnimator.INFINITE);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

                mHandler.postDelayed(rainProc, RAIN_GEN_INTERVAL);
            }
        }

