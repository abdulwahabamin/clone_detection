    private void clearPlayQueue(final String userName) {
        context.bindService(new Intent(context, PlayerService.class),
                new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        ((PlayerService.PlayerServiceBinder)service).removeRemoteUserSongs(userName);
                        context.unbindService(this);
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {}
                },
                Context.BIND_ABOVE_CLIENT);
    }

