        void stopDiscovery() {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.stopDiscovery();
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

