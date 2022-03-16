    private void updateWeatherData(final String city, final String lat, final String lon) {
        wt = new FetchWeather(context());
        if (citys == null)
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    fabProgressCircle.show();
                }
            }, 50);
        new Thread() {
            public void run() {
                try {
                    if (lat == null && lon == null) {
                        json = wt.execute(citys != null ? citys : city).get();
                    } else if (city == null) {
                        json = wt.execute(lat, lon).get();
                    }
                } catch (InterruptedException iex) {
                    Log.e("InterruptedException", "iex");
                } catch (ExecutionException eex) {
                    Log.e("ExecutionException", "eex");
                }
                if (pd.isShowing())
                    pd.dismiss();
                if (json == null) {
                    preferences.setCity(preferences.getLastCity());
                    handler.post(new Runnable() {
                        public void run() {
                            GlobalActivity.i = 1;
                            if (!preferences.getLaunched()) {
                                FirstStart();
                            } else {
                                if (citys == null)
                                    fabProgressCircle.hide();
                                cc = new CheckConnection(context());
                                if (!cc.isNetworkAvailable()) {
                                    showNoInternet();
                                } else {
                                    if (pd.isShowing())
                                        pd.dismiss();
                                    showInputDialog();
                                }
                            }
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            preferences.setLaunched();
                            renderWeather(json);
                            if (!preferences.getv3TargetShown())
                                showTargets();
                            if (pd.isShowing())
                                pd.dismiss();
                            if (citys == null) {
                                preferences.setLastCity(json.day.getName() + "," + json.day.getSys().getCountry());
                                ((WeatherActivity) activity()).createShortcuts();
                                progress();
                            } else
                                preferences.setLastCity(preferences.getLastCity());
                            NotificationService.enqueueWork(context(), new Intent(context(), WeatherActivity.class));
                        }
                    });
                }
            }
        }.start();
    }

