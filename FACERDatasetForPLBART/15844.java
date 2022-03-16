        public void sendRequest(final String deviceId, final int action,
                                final Object requestData,
                                final ResponseListener responseListener) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.sendRequest(deviceId, action, requestData, responseListener);
                }
            };
            handler.executeAsync(r, THREAD_REQUEST+session++);
        }

