    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfoIn) {
        if (menuInfoIn == null) return;

        AdapterView.AdapterContextMenuInfo mi = (AdapterView.AdapterContextMenuInfo) menuInfoIn;
        selectedPosition = mi.position;
        adapter.getCursor().moveToPosition(selectedPosition);
        try {
            int id_idx = adapter.getCursor().getColumnIndexOrThrow(MediaStore.Audio.Playlists.Members.AUDIO_ID);
            selectedId = adapter.getCursor().getLong(id_idx);
        } catch (IllegalArgumentException ex) {
            selectedId = mi.id;
        }

        menu.setHeaderTitle(adapter.getCursor().getString(adapter.getCursor().getColumnIndexOrThrow(
                MediaStore.Audio.AudioColumns.TITLE)));

        menu.add(0, R.id.track_play_now, 0, R.string.play_now);
        menu.add(0, R.id.track_play_next, 0, R.string.play_next);
        menu.add(0, R.id.track_queue, 0, R.string.queue);

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_to_playlist);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.track_new_playlist, R.id.track_selected_playlist);

        if (isEditMode()) {
            menu.add(0, R.id.track_remove_from_playlist, 0, R.string.remove_from_playlist);
        }

        if (!isEditMode()) {
            menu.add(0, R.id.track_delete, 0, R.string.delete_item);
        }

        menu.add(0, R.id.track_info, 0, R.string.info);

        menu.add(0, R.id.track_share_via, 0, R.string.share_via);

        // only add the 'search' menu if the selected item is music
        if (MusicUtils.isMusic(adapter.getCursor())) {
            menu.add(0, R.id.track_search_for_track, 0, R.string.search_for);
        }
    }

