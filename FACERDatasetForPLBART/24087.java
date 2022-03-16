    public static Intent searchForTrack(String trackName, String artistNameForAlbum, String albumName, Resources resources) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        String query;
        if (MediaStore.UNKNOWN_STRING.equals(artistNameForAlbum)) {
            query = trackName;
        } else {
            query = artistNameForAlbum + " " + trackName;
            intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artistNameForAlbum);
        }
        if (MediaStore.UNKNOWN_STRING.equals(albumName)) {
            intent.putExtra(MediaStore.EXTRA_MEDIA_ALBUM, albumName);
        }
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, "audio/*");
        intent.putExtra(SearchManager.QUERY, query);

        return Intent.createChooser(intent, resources.getString(R.string.mediasearch, trackName));
    }

