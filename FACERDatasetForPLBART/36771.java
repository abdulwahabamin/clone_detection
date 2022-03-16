    @Override
    public void onResume() {
        super.onResume();

        // start a timer for checking weather info from db
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                WeatherInfoDAO dao = new WeatherInfoDAO(CardFragment.this.getContext());
                final WeatherInfo info = dao.query(mCounty);
                dao.close();
                if (CardFragment.this.isVisible()) {
                    if (info != null) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                L.v(TAG, "Showing weather info: " + info.toString());
                                L.v(TAG, "Of county: " + mCounty.toString());
                                showWeatherInfo(info);
                            }
                        });
                    } else {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                L.v(TAG, "Showing empty weather info");
                                L.v(TAG, "Of county: " + mCounty.toString());
                                showEmptyInfo(mCounty);
                            }
                        });
                    }
                }
            }
        }, 0, 1000);
    }

