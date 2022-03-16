    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_failed_retry: {
                mPresenter.loadData();
            } break;
            case R.id.ib_city_weather_toolbar_cities: {
                navigateToCitiesActivity();
            } break;
            case R.id.ib_city_weather_toolbar_menu: {
                mPopupMenu.showAsDropDown(v);
            } break;
            case R.id.ll_pop_menu_item_refresh: {
                updateData();
                mPopupMenu.dismiss();
            } break;
            case R.id.ll_pop_menu_item_settings: {
//                if (mAnimationType == 0) {
//                    mAnimationType = 1;
//                } else {
//                    mAnimationType *= 2;
//                }
//                if (mAnimationType > ANIMATION_SUNSHINE) {
//                    mAnimationType = 0;
//                }
//                startAnimation(new WeatherEntity());

                navigateToSettingsActivity();
                mPopupMenu.dismiss();
            } break;
        }
    }

