        @Override
        public void run() {
            ++mSpecialWeatherNumCloud;
            if (mSpecialWeatherNumCloud <= mSpecialWeatherNumLimitCloud) {
                int toolbarHeight = 0;
                int screenWidth = DensityUtil.getScreenWidth(CityWeatherActivity.this);

                boolean isBack = (mSpecialWeatherNumCloud & 0x1) == 0;

                ImageView imageView = new ImageView(CityWeatherActivity.this);
                imageView.setVisibility(View.VISIBLE);
                if (isBack) {
                    //imageView.setImageResource(mCloudIconBackId);
                    mPresenter.getImageViewSrc(imageView, mCloudIconBackId);
                } else {
                    //imageView.setImageResource(mCloudIconFrontId);
                    mPresenter.getImageViewSrc(imageView, mCloudIconFrontId);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                if (isBack) {
                    layoutParams.setMargins(0, toolbarHeight, 0, 0);
                } else {
                    layoutParams.setMargins(0, toolbarHeight + mRandom.nextInt(100), 0, 0);
                }
                rlBackgroundView.addView(imageView, layoutParams);

                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", -(screenWidth * 2 / 3), screenWidth);
                if (isBack) {
                    animator.setDuration(CLOUD_SPEED_L);
                } else {
                    animator.setDuration(CLOUD_SPEED_H);
                }
                animator.setRepeatMode(ObjectAnimator.RESTART);
                animator.setRepeatCount(ObjectAnimator.INFINITE);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

                mHandler.postDelayed(cloudProc, CLOUD_GEN_INTERVAL);
            }
        }

