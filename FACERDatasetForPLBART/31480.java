    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getBackgroundImage(rlBackgroundView, R.drawable.night);
        mPresenter.getImageViewSrc(ibToolbarCities, R.drawable.ic_edit_location_white_24dp);
        mPresenter.getImageViewSrc(ibToolbarMenu, R.drawable.ic_menu_white_24dp);
    }

