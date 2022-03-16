    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mCreateShortcut) {
            menu.add(0, GOTO_START, 0, R.string.goto_start).setIcon(
                    R.drawable.ic_menu_music_library);
            menu.add(0, GOTO_PLAYBACK, 0, R.string.goto_playback).setIcon(
                    R.drawable.ic_menu_playback).setVisible(MusicUtils.isMusicLoaded());
        }
        return super.onCreateOptionsMenu(menu);
    }

