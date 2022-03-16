    private void updatePlaylistItems(Menu menu) {
        MenuItem item = menu.findItem(R.id.create_new_playlist);
        if (item != null) {
            ActionBar.Tab selectedTab = getActionBar().getSelectedTab();
            item.setVisible(selectedTab != null && selectedTab.getTag().equals(PlaylistFragment.class.getName()));
        }
    }

