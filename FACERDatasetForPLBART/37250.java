    private void getWeatherFromNet() {
        model.getWeatherFromNet(mCity)
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Weather weather) {
                        view.setRefreshing(false);
                        view.showWeather(weather);
                        view.showSnack(view.getContext().getString(R.string.update_tips));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "update weather fail", e);
                        view.setRefreshing(false);
                        if (NetworkUtils.errorByNetwork(e)) {
                            view.showSnack(view.getContext().getString(R.string.network_error));
                        } else {
                            view.showSnack("update weather error: " + e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

