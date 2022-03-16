    private void handleInfoAnimate(float percentage) {
        mToolbar.getBackground().mutate().setAlpha((int) (255 * percentage));
        mTitleContainer.setAlpha(1 - percentage);
        mTitleContainer.setScaleX(1 - percentage);
        mTitleContainer.setScaleY(1 - percentage);
        mHoursForecastRecyclerView.setAlpha(1 - percentage);

        if (mWeatherInfoContainerLeft > 0) {
            mTitleContainer.setX(mWeatherInfoContainerLeft * (1 - percentage));
        }

        if (!(percentage < percentageOfShowTitle)) {
            mTitleIcon.setImageResource(ResourceProvider.getIconId(mWeatherStatus));
            mTitleTemp.setText(mTemperature);
            if (mFloatAction.isShown()) {
                mFloatAction.hide();
            }
        } else {
            if (!mFloatAction.isShown() && !mActionRotate.isRunning()) {
                mFloatAction.show();
            }
            mTitleIcon.setImageDrawable(null);
            mTitleTemp.setText("");
        }
    }

