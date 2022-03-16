    @Override public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, TRACK_MENU, Menu.NONE, R.string.sort_by_track);
        menu.add(Menu.NONE, ALBUM_MENU, Menu.NONE, R.string.sort_by_album);
        menu.add(Menu.NONE, ARTIST_MENU, Menu.NONE, R.string.sort_by_artist);
        return true;
    }

