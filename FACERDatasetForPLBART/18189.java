    /**
     * Builds a HashMap of all artists and their individual albums count.
     */
    private void buildArtistsLibrary() {
        Cursor artistsCursor = mContext.getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                                        new String[] { MediaStore.Audio.Artists.ARTIST, MediaStore.Audio.Artists.NUMBER_OF_ALBUMS },
                                        null,
                                        null,
                                        null);

        if (artistsCursor==null)
            return;

        for (int i=0; i < artistsCursor.getCount(); i++) {
            artistsCursor.moveToPosition(i);
            mAlbumsCountMap.put(artistsCursor.getString(0), artistsCursor.getInt(1));

        }

        artistsCursor.close();
    }

