        public void onServiceConnected(ComponentName className, IBinder binderService) {
            weatherByVoiceService = new Messenger(binderService);
            weatherByVoiceServiceLock.lock();
            try {
                while (!weatherByvOiceUnsentMessages.isEmpty()) {
                    weatherByVoiceService.send(weatherByvOiceUnsentMessages.poll());
                }
            } catch (RemoteException e) {
                appendLog(getBaseContext(), TAG, e.getMessage(), e);
            } finally {
                weatherByVoiceServiceLock.unlock();
            }
        }

