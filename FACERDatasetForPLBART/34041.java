        @Override
        protected Void doInBackground(String... params) {
            long startTime = System.currentTimeMillis();
            long runningTime = 0;
            while (locationListener.getLocation() == null && runningTime < MAX_RUNNING_TIME) { // Give up after 30 seconds
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Log.e(TAG, "Error occurred while waiting for location update", e);
                }
                runningTime = System.currentTimeMillis() - startTime;
            }
            if (locationListener.getLocation() == null) {
                Log.d(TAG, String.format("Couldn't determine location in less than %s seconds", MAX_RUNNING_TIME / 1000));
            }
            return null;
        }

