    /**
     * @param id
     */
    private void tracksBrowser(long id) {

        String artistName = mCursor.getString(mArtistNameIndex);
        String artistNulAlbums = mCursor.getString(mArtistNumAlbumsIndex);        

        Bundle bundle = new Bundle();
        bundle.putString(MIME_TYPE, Audio.Artists.CONTENT_TYPE);
        bundle.putString(ARTIST_KEY, artistName);
        bundle.putString(NUMALBUMS, artistNulAlbums);
        
        bundle.putLong(BaseColumns._ID, id);

        ApolloUtils.setArtistId(artistName, id, ARTIST_ID, getActivity());

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setClass(getActivity(), TracksBrowser.class);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

