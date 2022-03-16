    @Override
    public void onCreate() {
        super.onCreate();

        findClock();

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                updateViews();
            }
        }, 0, 1000);
    }

