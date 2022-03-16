    private Cursor fetchArtists() {
        return getContext().getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI,
                new String[] {
                        MediaStore.Audio.Artists._ID,
                        MediaStore.Audio.Artists.ARTIST,
                        MediaStore.Audio.Artists.NUMBER_OF_TRACKS
                },
                MediaStore.Audio.Artists.ARTIST + " != ''",
                null,
                MediaStore.Audio.Artists.DEFAULT_SORT_ORDER);
    }

