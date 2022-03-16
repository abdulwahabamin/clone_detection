        public void newQueue(final PlayQueue queue) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.newQueue(queue);
                    service.play();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

