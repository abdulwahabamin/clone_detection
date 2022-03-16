        public void seek(final int seek) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.seek(seek);
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

