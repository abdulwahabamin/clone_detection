        public void changeTrack(final int songIndex) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.changeTrack(songIndex);
                    service.play();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

