    @Override
    public Iterator<MediaMetadataCompat> iterator(String mediaId) {
        FireLog.d(TAG, "(++) iterator, mediaId=" + mediaId);

        if (MEDIA_ID_ROOT.equals(mediaId)) {
            return new ArrayList<MediaMetadataCompat>().iterator();

        } else if (MEDIA_ID_TRACKS.equals(mediaId)) {
            List<MediaMetadataCompat> tracks = getLocalTracks();
            return tracks.iterator();
        } else if (MEDIA_ID_PLAYLIST.equals(mediaId)) {
            return getLocalPlayLists().iterator();
        } else if (MEDIA_ID_ALBUM.equals(mediaId)) {
            return getLocalAlbums().iterator();
        } else if (MEDIA_ID_ARTIST.equals(mediaId)) {
            return getLocalArtists().iterator();
        } else if (MEDIA_ID_GENRE.equals(mediaId)) {
            return getLocalGenres().iterator();
        } else if (MEDIA_ID_FOLDER.equals(mediaId)) {
            return getLocalFolders().iterator();
        } else if (mediaId.startsWith(MEDIA_ID_PLAYLIST) || mediaId.startsWith(MEDIA_ID_ALBUM)
                || mediaId.startsWith(MEDIA_ID_ARTIST) || mediaId.startsWith(MEDIA_ID_GENRE)
                || mediaId.startsWith(MEDIA_ID_FOLDER)) {
            String category = MediaIDHelper.getHierarchy(mediaId)[0];
            String subCategory = MediaIDHelper.getHierarchy(mediaId)[1];
            return getTracksBySubCategory(category, subCategory).iterator();
        } else {
            FireLog.w(TAG, "unmatched mediaId: " + mediaId);
            return new ArrayList<MediaMetadataCompat>().iterator();
        }
    }

