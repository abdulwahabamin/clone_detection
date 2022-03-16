        @Override
        public void run() {
            int toolbarHeight = 0;

            ImageView imageView = new ImageView(CityWeatherActivity.this);
            imageView.setVisibility(View.VISIBLE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            //imageView.setImageResource(R.drawable.sunshine_2);
            mPresenter.getImageViewSrc(imageView, R.drawable.sunshine_2);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.setMargins(0, toolbarHeight, 0, 0);
            rlBackgroundView.addView(imageView, layoutParams);

            ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 0.6f, 1f);
            animator.setDuration(SUNSHINE_SPEED_H);
            animator.setRepeatMode(ObjectAnimator.REVERSE);
            animator.setRepeatCount(ObjectAnimator.INFINITE);
            animator.setInterpolator(new AccelerateInterpolator());
            animator.start();
        }

