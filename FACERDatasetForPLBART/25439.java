    @Override
    protected void onStart() {
        super.onStart();
        // Bind to PlayerService
        Intent i = new Intent(this, PlayerService.class);
        bindService(i, mConnection, Context.BIND_AUTO_CREATE);
    }

