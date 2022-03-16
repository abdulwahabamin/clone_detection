    private void resultFromServer(final T t) {
        final String loc = mConcurrentMap.get(t);
        Weather weather = null;
        Future<Weather> f = mTasker.setOtherTask(new WeatherTaskPool(loc));
        try {
            Log.d(TAG, "resultFromServer: " + f.get());
            weather = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        final Weather finalWeather = weather;
        mMainThreadCallback.post(new Runnable() {
            @Override
            public void run() {
                if (mQuit || !mConcurrentMap.get(t).equals(loc)) {
                    return;
                }
                if (finalWeather != null) {
                    mConcurrentMap.remove(t);
                    mWeatherFetchListener.onDataFetched(t, finalWeather);
                } else {
                    mConcurrentMap.remove(t);
                    mWeatherFetchListener.onDataFetched(t, null);
                }
            }
        });
    }

