    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.browser_menu, menu);

        if (getResources().getBoolean(R.bool.tablet_layout)) {
            SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, 16, R.string.add_all_to_playlist);
            MusicUtils.makePlaylistMenu(this, sub, R.id.new_playlist, R.id.selected_playlist);
        }

        return true;
    }

