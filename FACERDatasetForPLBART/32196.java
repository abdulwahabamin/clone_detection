        public void onServiceConnected(ComponentName className, IBinder binderService) {
            weatherForecastService = new Messenger(binderService);
            weatherForecastServiceLock.lock();
            try {
                while (!weatherForecastUnsentMessages.isEmpty()) {
                    weatherForecastService.send(weatherForecastUnsentMessages.poll());
                }
            } catch (RemoteException e) {
                appendLog(getBaseContext(), TAG, e.getMessage(), e);
            } finally {
                weatherForecastServiceLock.unlock();
            }
            serviceConnected(currentWeatherServiceConnection);
        }

