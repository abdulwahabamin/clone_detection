    @Override
    public void updateItem(FollowedCityData data, int position) {
        if (data == null) {
            return;
        }

        mFollowedCityData = data;
        mImage.setScaleType(ImageView.ScaleType.FIT_XY);
        mImage.setImageResource(data.backgroundId);
        mCityTemp.setText(data.temp);
        mCityName.setText(data.cityName);
        mCityStatus.setText(data.weatherStatus);

        Drawable drawableLeft = UIUtil.getDrawable(getContext(), ResourceProvider.getIconId(data.weatherStatus));
        drawableLeft.setBounds(0, 0, UIUtil.dipToPx(getContext(), R.dimen.common_icon_size_small), UIUtil.dipToPx(getContext(), R.dimen.common_icon_size_small));
        mCityStatus.setCompoundDrawables(drawableLeft, null, null, null);

        mDelete.setVisibility(mCityWeatherAdapter.mIsDeleting ? View.VISIBLE : View.GONE);
        mHover.setVisibility(mCityWeatherAdapter.mIsDeleting ? View.VISIBLE : View.GONE);


        if (data.cityId.equals(CoreManager.getImpl(ILocationApi.class).getLocatedCityId())) {
            mDelete.setVisibility(View.GONE);
            mHover.setVisibility(View.GONE);

            mCityName.setCompoundDrawables(mDrawableLocation, null, null, null);
        } else {
            mCityName.setCompoundDrawables(null, null, null, null);
        }

        boolean isDefault = data.cityId.equals(CoreManager.getImpl(ICityProvider.class).getCurrentCityId());
        mChecked.setVisibility(isDefault ? View.VISIBLE : View.GONE);

    }

