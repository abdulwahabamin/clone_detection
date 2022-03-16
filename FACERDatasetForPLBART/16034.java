    private void libraryChanged(String userName) {
        songsFragment.onLibraryChanged(Library.getSongs(userName));
        if(backAction != null) {
            backAction.run();
        }
        albumsFragment.onLibraryChanged(Library.getAlbums(userName));
    }

