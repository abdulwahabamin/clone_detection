    @Override
    public void onAlbumClicked(Cursor albumCursor, int position) {
        String username = null;
        albumCursor.moveToPosition(position);
        if(Library.getInt(albumCursor, AlbumTable.Columns.IS_REMOTE) == 1) {
            username = Library.getString(albumCursor, AlbumTable.Columns.REMOTE_USERNAME);
        }
        Cursor albumSongsCursor = Library.getAlbumSongs(username,
                Library.getLong(albumCursor, AlbumTable.Columns.ALBUM_ID));

        final SongsFragment albumSongsFragment = SongsFragment.newInstance(albumSongsCursor, this);
        pagerAdapter.changeAlbumsFragment(albumSongsFragment);

        final MainActivity mainActivity = (MainActivity) getActivity();

        backAction = new Runnable() {
            @Override
            public void run() {
                backAction = null;
                pagerAdapter.changeAlbumsFragment(albumsFragment);
                albumSongsFragment.closeCursors();
                mainActivity.overrideBackButton(null);
            }
        };

        mainActivity.overrideBackButton(backAction);
    }

