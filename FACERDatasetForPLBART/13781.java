    private Music getCurrentMusic() {
        if (uriMediaSource.getSize() > 0) {
            MediaSource currentMediaSource = uriMediaSource.getMediaSource(exoPlayer.getCurrentWindowIndex());
            return playlist.get(currentMediaSource);
        } else {
            return null;
        }
    }

