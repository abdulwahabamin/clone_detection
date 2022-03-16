    @Override
    public boolean onUnbind(Intent intent) {
        if(!player.isPlaying()) {
            endService(true);
        }
        isBound = false;
        return true;
    }

