    private void tracksBrowser(int index, long id) {

        String genreKey = mCursor.getString(mGenreNameIndex);

        Bundle bundle = new Bundle();
        bundle.putString(MIME_TYPE, Audio.Genres.CONTENT_TYPE);
        bundle.putString(GENRE_KEY, genreKey);
        bundle.putLong(BaseColumns._ID, id);

        Intent intent = new Intent(getActivity(), TracksBrowser.class);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

