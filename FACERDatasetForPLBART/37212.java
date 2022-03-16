    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawers();
        handler.postDelayed(() -> item.setChecked(false), 500);
        switch (item.getItemId()) {
            case R.id.action_image_weather:
                presenter.startImageWeather();
                return true;
            case R.id.action_location:
                presenter.startManage();
                return true;
            case R.id.action_setting:
                presenter.startSetting();
                break;
            case R.id.action_share:
                presenter.share();
                return true;
            case R.id.action_about:
                presenter.startAbout();
                return true;
        }
        return false;
    }

