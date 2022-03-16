    @Override
    public void onResume() {
        super.onResume();

        //start PlayerService
        Intent intent = new Intent(this, PlayerService.class);
        startService(intent);
        this.bindService(intent, serviceConnection, Context.BIND_ABOVE_CLIENT);
    }

