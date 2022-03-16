    @Override
    public int getDuration() {
        if (musicSrv != null)
            return musicSrv.getDuration();
        return 0;
    }

