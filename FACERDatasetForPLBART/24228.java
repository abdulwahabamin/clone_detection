    @Override
    protected long fetchCurrentlyPlayingCategoryId() {
        return (MusicUtils.sService != null)
                ? MusicUtils.sService.getArtistId()
                : -1;
    }

