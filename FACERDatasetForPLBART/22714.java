    private void loadChildren(final String parentId, final Result<List<MediaBrowser.MediaItem>> result) {

        final List<MediaBrowser.MediaItem> mediaItems = new ArrayList<>();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... unused) {

                if (parentId.equals(MEDIA_ID_ROOT)) {
                    addMediaRoots(mediaItems);
                } else {
                    switch (Integer.parseInt(Character.toString(parentId.charAt(0)))) {
                        case TYPE_ARTIST:
                            List<Artist> artistList = ArtistLoader.getAllArtists(mContext);
                            for (Artist artist : artistList) {
                                String albumNmber = TimberUtils.makeLabel(mContext, R.plurals.Nalbums, artist.albumCount);
                                String songCount = TimberUtils.makeLabel(mContext, R.plurals.Nsongs, artist.songCount);
                                fillMediaItems(mediaItems, Integer.toString(TYPE_ARTIST_SONG_ALBUMS) + Long.toString(artist.id), artist.name, Uri.parse("android.resource://" +
                                        "naman14.timber/drawable/ic_empty_music2"), TimberUtils.makeCombinedString(mContext, albumNmber, songCount), MediaBrowser.MediaItem.FLAG_BROWSABLE);
                            }
                            break;
                        case TYPE_ALBUM:
                            List<Album> albumList = AlbumLoader.getAllAlbums(mContext);
                            for (Album album : albumList) {
                                fillMediaItems(mediaItems, Integer.toString(TYPE_ALBUM_SONGS) + Long.toString(album.id), album.title, TimberUtils.getAlbumArtUri(album.id), album.artistName, MediaBrowser.MediaItem.FLAG_BROWSABLE);
                            }
                            break;
                        case TYPE_SONG:
                            List<Song> songList = SongLoader.getAllSongs(mContext);
                            for (Song song : songList) {
                                fillMediaItems(mediaItems, String.valueOf(song.id), song.title, TimberUtils.getAlbumArtUri(song.albumId), song.artistName, MediaBrowser.MediaItem.FLAG_PLAYABLE);
                            }
                            break;
                        case TYPE_ALBUM_SONGS:
                            List<Song> albumSongList = AlbumSongLoader.getSongsForAlbum(mContext, Long.parseLong(parentId.substring(1)));
                            for (Song song : albumSongList) {
                                fillMediaItems(mediaItems, String.valueOf(song.id), song.title, TimberUtils.getAlbumArtUri(song.albumId), song.artistName, MediaBrowser.MediaItem.FLAG_PLAYABLE);
                            }
                            break;
                        case TYPE_ARTIST_SONG_ALBUMS:
                            fillMediaItems(mediaItems, Integer.toString(TYPE_ARTIST_ALL_SONGS) + Long.parseLong(parentId.substring(1)), "All songs", Uri.parse("android.resource://" +
                                    "naman14.timber/drawable/ic_empty_music2"), "All songs by artist", MediaBrowser.MediaItem.FLAG_BROWSABLE);
                            List<Album> artistAlbums = ArtistAlbumLoader.getAlbumsForArtist(mContext, Long.parseLong(parentId.substring(1)));
                            for (Album album : artistAlbums) {
                                String songCount = TimberUtils.makeLabel(mContext, R.plurals.Nsongs, album.songCount);
                                fillMediaItems(mediaItems, Integer.toString(TYPE_ALBUM_SONGS) + Long.toString(album.id), album.title, TimberUtils.getAlbumArtUri(album.id), songCount, MediaBrowser.MediaItem.FLAG_BROWSABLE);

                            }
                            break;
                        case TYPE_ARTIST_ALL_SONGS:
                            List<Song> artistSongs = ArtistSongLoader.getSongsForArtist(mContext, Long.parseLong(parentId.substring(1)));
                            for (Song song : artistSongs) {
                                fillMediaItems(mediaItems, String.valueOf(song.id), song.title, TimberUtils.getAlbumArtUri(song.albumId), song.albumName, MediaBrowser.MediaItem.FLAG_PLAYABLE);
                            }
                            break;
                        case TYPE_PLAYLIST:
                            List<Playlist> playlistList = PlaylistLoader.getPlaylists(mContext, false);
                            for (Playlist playlist : playlistList) {
                                String songCount = TimberUtils.makeLabel(mContext, R.plurals.Nsongs, playlist.songCount);
                                fillMediaItems(mediaItems, Integer.toString(TYPE_PLAYLIST_ALL_SONGS) + Long.toString(playlist.id), playlist.name,
                                        Uri.parse("android.resource://" +
                                                "naman14.timber/drawable/ic_empty_music2"), songCount, MediaBrowser.MediaItem.FLAG_BROWSABLE);
                            }
                            break;
                        case TYPE_PLAYLIST_ALL_SONGS:
                            List<Song> playlistSongs = PlaylistSongLoader.getSongsInPlaylist(mContext, Long.parseLong(parentId.substring(1)));
                            for (Song song : playlistSongs) {
                                fillMediaItems(mediaItems, String.valueOf(song.id), song.title, TimberUtils.getAlbumArtUri(song.albumId), song.albumName, MediaBrowser.MediaItem.FLAG_PLAYABLE);
                            }
                            break;

                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                result.sendResult(mediaItems);
            }
        }.execute();

    }

