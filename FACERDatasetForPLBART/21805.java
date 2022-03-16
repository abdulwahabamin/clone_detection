    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (showAuto) {
            menu.findItem(R.id.action_view_auto_playlists).setTitle("Hide auto playlists");
        } else menu.findItem(R.id.action_view_auto_playlists).setTitle("Show auto playlists");
    }

