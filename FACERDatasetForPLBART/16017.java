    public static AlbumsFragment newInstance(Cursor albumCursor,
                                             final AlbumAdapter.AlbumClickListener listener) {
        final AlbumsFragment fragment = new AlbumsFragment();
        fragment.albumAdapter = new AlbumAdapter(albumCursor, new AlbumAdapter.AlbumClickListener() {
            @Override
            public void onAlbumClicked(Cursor albumCursor, int position) {
                fragment.savedPosition = position;
                listener.onAlbumClicked(albumCursor, position);
            }
        });
        return fragment;
    }

