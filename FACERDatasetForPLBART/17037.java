    @Override
    public List<MediaMetadataCompat> getArtistListFromLocalStorage() {
        List<MediaMetadataCompat> artistList = new ArrayList<>();
        Cursor artistsCursor = getArtistsCursor();

        if (artistsCursor.moveToFirst()) {
            do {
                artistList.add(buildArtistMetadata(artistsCursor));
            } while (artistsCursor.moveToNext());
        }

        return artistList;
    }

