    public void addToFavorites(String mediaId) {
        if (isSongInFavourites(mediaId)) {
            return;
        }

        mPlaylistSongsByPlaylistKey
                .get(PlaylistsSource.FAVORITES_PLAYLIST_ID+"")
                .add(mMusicProvider.getMusic(mediaId));
        mPlaylistsSource.addMusicMediaIdToPlaylist(PlaylistsSource.FAVORITES_PLAYLIST_ID, mediaId);

        Playlist playlist = mPlaylistsSource.getPlaylistById(PlaylistsSource.FAVORITES_PLAYLIST_ID);

        mAllPlaylistsByKey
                .put(
                        playlist.getId()+"",
                        PlaylistHelper
                                .createPlaylistMetadata(
                                        playlist.getId()+"",
                                        playlist.getTitle(),
                                        playlist.getMusicMediaIds().size(),
                                        playlist.getIconDrawableId(),
                                        playlist.getColor(),
                                        playlist.getType()));

        if (mPlaylistsCallback != null) {
            mPlaylistsCallback.onFavoriteStatusChange(mediaId, true);
            mPlaylistsCallback.onPlaylistsChanged(PlaylistsSource.FAVORITES_PLAYLIST_ID+"");
        }
    }

