    public synchronized void retrievePlaylists() {
        Log.d(TAG, "retrievePlaylists:called");

        try {
            if (!mMusicProvider.isInitialized()) {
                mMusicProvider.retrieveMedia();
            }

            String playlistKey = PlaylistHelper.createPlaylistId();
            List<MediaMetadataCompat> lastAddedPlaylist = new ArrayList<>(mMusicProvider.getSongs());

            MediaListHelper.sortByDateModified(lastAddedPlaylist);

            mAllPlaylistsByKey.put(
                    playlistKey,
                    PlaylistHelper
                            .createPlaylistMetadata(
                                    playlistKey,
                                    PlaylistsSource.LAST_ADDED_PLAYLIST_TITLE,
                                    lastAddedPlaylist.size(),
                                    PlaylistsSource.LAST_ADDED_PLAYLIST_ICON_DRAWABLE_ID,
                                    PlaylistsSource.LAST_ADDED_PLAYLIST_COLOR,
                                    PlaylistsSource.PLAYLIST_TYPE_AUTO));

            mPlaylistSongsByPlaylistKey.put(playlistKey, lastAddedPlaylist);

            List<String> playlistIds = mPlaylistsSource.getPlaylistIds();

            if (playlistIds == null) {
                mPlaylistsSource.createPlaylistIdList();
                mPlaylistsSource.addNewPlaylist(
                        new Playlist(
                                PlaylistsSource.FAVORITES_PLAYLIST_ID,
                                PlaylistsSource.FAVORITES_PLAYLIST_TITLE,
                                PlaylistsSource.PLAYLIST_TYPE_AUTO,
                                PlaylistsSource.FAVORITES_PLAYLIST_ICON_DRAWABLE_ID,
                                PlaylistsSource.FAVORITES_PLAYLIST_COLOR));
            } else if (playlistIds.size() == 0) {
                    mPlaylistsSource.addNewPlaylist(
                            new Playlist(
                                    PlaylistsSource.FAVORITES_PLAYLIST_ID,
                                    PlaylistsSource.FAVORITES_PLAYLIST_TITLE,
                                    PlaylistsSource.PLAYLIST_TYPE_AUTO,
                                    PlaylistsSource.FAVORITES_PLAYLIST_ICON_DRAWABLE_ID,
                                    PlaylistsSource.FAVORITES_PLAYLIST_COLOR));
            }

            for (String playlistId : mPlaylistsSource.getPlaylistIds()) {
                List<MediaMetadataCompat> metadataList = new ArrayList<>();
                Playlist playlist = mPlaylistsSource.getPlaylistById(Long.parseLong(playlistId));

                if (playlist == null) {
                    continue;
                }

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

                for (String mediaId : playlist.getMusicMediaIds()) {
                    metadataList.add(mMusicProvider.getMusic(mediaId));
                }
                mPlaylistSongsByPlaylistKey.put(playlist.getId()+"", metadataList);
            }

            mCurrentState = PlaylistsManager.State.INITIALIZED;
        } catch (Exception e){
            Log.e(TAG, "retrieveMedia:", e);
            e.printStackTrace();
        } finally {
            if (mCurrentState != State.INITIALIZED) {
                Log.w(TAG, "retrieveMedia:state is not initialized");
                // setting state to non-initialized to allow retires
                // if something bad happened
                mCurrentState = State.NON_INITIALIZED;
            }
        }
    }

