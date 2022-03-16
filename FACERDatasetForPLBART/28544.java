    @Override
    public void updateCurrentWeather(CurrentWeatherData data) {
        if(refreshActionButton != null && refreshActionButton.getActionView() != null) {
            refreshActionButton.getActionView().clearAnimation();
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(pagerAdapter.getPageTitleForActionBar(viewPager.getCurrentItem()));
        }
    }

