        public void getRawSocket(final String deviceId, final ResponseListener responseListener) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.getRawSocket(deviceId, responseListener);
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

