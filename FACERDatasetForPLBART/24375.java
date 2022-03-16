    private void setupTabs(ActionBar actionBar) {
        viewPager.setAdapter(null);

        actionBar.removeAllTabs();

        setupTab(actionBar, SettingsActivity.SHOW_ARTISTS_TAB, R.string.artists_menu, ArtistFragment.class);
        setupTab(actionBar, SettingsActivity.SHOW_ALBUMS_TAB, R.string.albums_menu, AlbumFragment.class);
        setupTab(actionBar, SettingsActivity.SHOW_GENRES_TAB, R.string.genres_menu, GenreFragment.class);
        setupTab(actionBar, SettingsActivity.SHOW_FOLDERS_TAB, R.string.folders_menu, FolderFragment.class);
        setupTab(actionBar, SettingsActivity.SHOW_PLAYLISTS_TAB, R.string.playlists_menu, PlaylistFragment.class);

        viewPager.setAdapter(new CategoryPageAdapter(getFragmentManager()));
    }

