    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfoIn) {
        if (menuInfoIn == null) return;

        AdapterContextMenuInfo mi = (AdapterContextMenuInfo) menuInfoIn;
        currentId = mi.id;
        adapter.getCursor().moveToPosition(mi.position);
        playlistName = adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(MusicContract.Playlist.NAME));
        menu.setHeaderTitle(playlistName);

        menu.add(0, R.id.playlist_play_all_now, 0, R.string.play_all_now);
        menu.add(0, R.id.playlist_play_all_next, 0, R.string.play_all_next);
        menu.add(0, R.id.playlist_queue_all, 0, R.string.queue_all);
        SubMenu interleave = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.interleave_all);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                Intent intent = new Intent();
                intent.putExtra(CURRENT_COUNT, i);
                intent.putExtra(NEW_COUNT, j);
                interleave.add(2, R.id.playlist_interleave_all, 0, getResources().getString(R.string.interleaveNNN, i, j)).setIntent(intent);
            }
        }

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_all_to_playlist);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.playlist_new_playlist, R.id.playlist_selected_playlist);

        if (currentId >= 0) {
            menu.add(0, R.id.playlist_delete_playlist, 0, R.string.delete_playlist_menu);
            menu.add(0, R.id.playlist_rename_playlist, 0, R.string.rename_playlist_menu);
        }

        if (currentId == MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST) {
            menu.add(0, R.id.playlist_edit_playlist, 0, R.string.edit_playlist_menu);
        }

        if (currentId >= 0) {
            menu.add(0, R.id.playlist_export_playlist, 0, R.string.export_playlist_menu);
            menu.add(0, R.id.playlist_share_playlist, 0, R.string.share_via);
        }
    }

