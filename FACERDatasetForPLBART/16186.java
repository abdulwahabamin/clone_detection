        public void pause(){
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.pause();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

