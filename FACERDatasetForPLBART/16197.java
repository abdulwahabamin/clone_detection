    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null && intent.hasExtra(EXTRA_PLAY_CONTROL)) {
            String extraPlayControl = intent.getStringExtra(EXTRA_PLAY_CONTROL);

            switch (extraPlayControl) {
                case PLAY:
                    handler.executeAsync(new Runnable() {
                        @Override
                        public void run() {
                            ((PlayerServiceBinder)binder).restoreSavedQueue();
                            ((PlayerServiceBinder)binder).play();
                        }
                    }, PLAYER_HANDLER_THREAD_NAME);

                    break;
                case PAUSE:
                    ((PlayerServiceBinder)binder).pause();
                    break;
                case NEXT:
                    ((PlayerServiceBinder)binder).next();
                    break;
                case PREV:
                    ((PlayerServiceBinder)binder).prev();
                    break;
            }
        }

        return START_STICKY;
    }

