        public void play(){
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    service.play();
                }
            };
            handler.executeAsync(r, PLAYER_HANDLER_THREAD_NAME);
        }

