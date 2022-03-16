    @Override
    public void onDestroy() {
        super.onDestroy();
        songsFragment.closeCursors();
        albumsFragment.closeCursors();
    }

