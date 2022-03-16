        public void prev() {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.prev();
                    service.play();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

