    @Override
    protected void pupulareContextMenu(ContextMenu menu) {
        menu.add(0, R.id.genre_play_all_now, 0, R.string.play_all_now);
        menu.add(0, R.id.genre_play_all_next, 0, R.string.play_all_next);
        menu.add(0, R.id.genre_queue_all, 0, R.string.queue_all);
        SubMenu interleave = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.interleave_all);
        for (int i = 1; i<=5; i++) {
            for (int j = 1; j<=5; j++) {
                Intent intent = new Intent();
                intent.putExtra(CURRENT_COUNT, i);
                intent.putExtra(NEW_COUNT, j);
                interleave.add(2, R.id.genre_interleave_all, 0, getResources().getString(R.string.interleaveNNN, i, j)).setIntent(intent);
            }
        }

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_all_to_playlist);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.genre_new_playlist, R.id.genre_selected_playlist);

        menu.add(0, R.id.genre_delete_all, 0, R.string.delete_all);

        if (!mIsUnknown) {
            menu.add(0, R.id.genre_search_for_category, 0, R.string.search_for);
        }
    }

