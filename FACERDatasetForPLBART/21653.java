    private static void makeDefaultPlaylists(Context context) {
        final Resources resources = context.getResources();

        /* Last added list */
        final Playlist lastAdded = new Playlist(TimberUtils.PlaylistType.LastAdded.mId,
                resources.getString(TimberUtils.PlaylistType.LastAdded.mTitleId), -1);
        mPlaylistList.add(lastAdded);

        /* Recently Played */
        final Playlist recentlyPlayed = new Playlist(TimberUtils.PlaylistType.RecentlyPlayed.mId,
                resources.getString(TimberUtils.PlaylistType.RecentlyPlayed.mTitleId), -1);
        mPlaylistList.add(recentlyPlayed);

        /* Top Tracks */
        final Playlist topTracks = new Playlist(TimberUtils.PlaylistType.TopTracks.mId,
                resources.getString(TimberUtils.PlaylistType.TopTracks.mTitleId), -1);
        mPlaylistList.add(topTracks);
    }

