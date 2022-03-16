        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            switch (what) {
                case MSG_START: {
                    startAnimation();
                    mPresenter.attachView(SplashActivity.this);
                    mPresenter.start();
                } break;
                case MSG_NAVIGATE_CITY_WEATHER: {
                    Intent intent = new Intent(SplashActivity.this, CityWeatherActivity.class);
                    intent.putExtra(CityWeatherActivity.CITY_ID, mCityId);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                } break;
                case MSG_NAVIGATE_CITIES: {
                    Intent intent = new Intent(SplashActivity.this, CitiesActivity.class);
                    intent.putExtra(CitiesActivity.LOC_CITY_ID, mLocateCityId);
                    intent.putExtra(CitiesActivity.CITY_ID, mCityId);
                    intent.putExtra(CitiesActivity.LOCATE_RESULT, mIsLocateSucceeded);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                } break;
            }

            super.handleMessage(msg);
        }

