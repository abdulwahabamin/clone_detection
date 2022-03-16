        public void next() {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.next();
                    service.play();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

