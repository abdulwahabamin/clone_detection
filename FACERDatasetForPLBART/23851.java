    private void updateCurrentTrackInfo() {

        Song currentTrack = null;
        if (musicSrv != null) {
            currentTrack = musicSrv.getCurrentSong();
        }

        if (currentTrack != null) {
            if (currentTrack.getId() != mPlayingSongId) {
                mPlayingSongId = currentTrack.getId();
                mPlayingAlbum.setText(currentTrack.getAlbum());
                mPlayingSong.setText(currentTrack.getTitle());
                mPlayingArtist.setText(currentTrack.getArtist());
                mImageLoader.loadImage(mPlayingSongId, mPlayingArtwork);
            }
        } else {
            mPlayingAlbum.setText("");
            mPlayingSong.setText("");
            mPlayingArtist.setText("");
            mPlayingArtwork.setImageResource(R.drawable.ic_launcher_icon);
            mPlayingSongId = -1;
        }
    }

