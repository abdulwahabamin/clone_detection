    /**
     * Takes you into the @TracksBrowser to view all of the tracks and albums by
     * the current artist
     */
    private void tracksBrowserArtist() {

        String artistName = MusicUtils.getArtistName();
        long id = MusicUtils.getCurrentArtistId();

        Bundle bundle = new Bundle();
        bundle.putString(MIME_TYPE, Audio.Artists.CONTENT_TYPE);
        bundle.putString(ARTIST_KEY, artistName);
        bundle.putLong(BaseColumns._ID, id);

        ApolloUtils.setArtistId(artistName, id, ARTIST_ID, getActivity());

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClass(getActivity(), TracksBrowser.class);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

