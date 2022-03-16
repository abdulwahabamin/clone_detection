        void discoverGroups(final NewGroupListener groupListener,
                            final ErrorListener errorListener) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.discoverGroups(groupListener, errorListener);
                }
            };
            handler.executeAsync(r, THREAD_NETWORK_MANAGER);
        }

