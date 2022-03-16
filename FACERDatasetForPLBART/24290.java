    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.player_menu, menu);

        if (MusicUtils.android44OrLater() || !MusicUtils.hasMenuKey(this)) {
            menu.findItem(R.id.shuffle).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, 16, R.string.add_all_to_playlist);
        MusicUtils.makePlaylistMenu(this, sub, R.id.new_playlist, R.id.selected_playlist);

        return true;
    }

