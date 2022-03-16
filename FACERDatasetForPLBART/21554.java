    private String getAlbumArtUri(int position, long id) {
        if (mContext != null) {
            firstAlbumID = -1;
            if (showAuto) {
                switch (position) {
                    case 0:
                        List<Song> lastAddedSongs = LastAddedLoader.getLastAddedSongs(mContext);
                        songCountInt = lastAddedSongs.size();
                        totalRuntime = 0;
                        for (Song song : lastAddedSongs) {
                            totalRuntime += song.duration / 1000; //for some reason default playlists have songs with durations 1000x larger than they should be
                        }

                        if (songCountInt != 0) {
                            firstAlbumID = lastAddedSongs.get(0).albumId;
                            return TimberUtils.getAlbumArtUri(firstAlbumID).toString();
                        } else return "nosongs";
                    case 1:
                        TopTracksLoader recentloader = new TopTracksLoader(mContext, TopTracksLoader.QueryType.RecentSongs);
                        List<Song> recentsongs = SongLoader.getSongsForCursor(TopTracksLoader.getCursor());
                        songCountInt = recentsongs.size();
                        totalRuntime = 0;
                        for (Song song : recentsongs) {
                            totalRuntime += song.duration / 1000; //for some reason default playlists have songs with durations 1000x larger than they should be
                        }

                        if (songCountInt != 0) {
                            firstAlbumID = recentsongs.get(0).albumId;
                            return TimberUtils.getAlbumArtUri(firstAlbumID).toString();
                        } else return "nosongs";
                    case 2:
                        TopTracksLoader topTracksLoader = new TopTracksLoader(mContext, TopTracksLoader.QueryType.TopTracks);
                        List<Song> topsongs = SongLoader.getSongsForCursor(TopTracksLoader.getCursor());
                        songCountInt = topsongs.size();
                        totalRuntime = 0;
                        for (Song song : topsongs) {
                            totalRuntime += song.duration / 1000; //for some reason default playlists have songs with durations 1000x larger than they should be
                        }

                        if (songCountInt != 0) {
                            firstAlbumID = topsongs.get(0).albumId;
                            return TimberUtils.getAlbumArtUri(firstAlbumID).toString();
                        } else return "nosongs";
                    default:
                        List<Song> playlistsongs = PlaylistSongLoader.getSongsInPlaylist(mContext, id);
                        songCountInt = playlistsongs.size();
                        totalRuntime = 0;
                        for (Song song : playlistsongs) {
                            totalRuntime += song.duration;
                        }

                        if (songCountInt != 0) {
                            firstAlbumID = playlistsongs.get(0).albumId;
                            return TimberUtils.getAlbumArtUri(firstAlbumID).toString();
                        } else return "nosongs";

                }
            } else {
                List<Song> playlistsongs = PlaylistSongLoader.getSongsInPlaylist(mContext, id);
                songCountInt = playlistsongs.size();
                totalRuntime = 0;
                for (Song song : playlistsongs) {
                    totalRuntime += song.duration;
                }

                if (songCountInt != 0) {
                    firstAlbumID = playlistsongs.get(0).albumId;
                    return TimberUtils.getAlbumArtUri(firstAlbumID).toString();
                } else return "nosongs";
            }
        }
        return null;
    }

