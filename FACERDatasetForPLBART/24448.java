    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfoIn) {
        if (menuInfoIn == null) return;
        AdapterView.AdapterContextMenuInfo mi = (AdapterView.AdapterContextMenuInfo) menuInfoIn;
        mSelectedPosition = mi.position;
        playQueueCursor.moveToPosition(mSelectedPosition);
        mSelectedId = playQueueCursor.getLong(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns._ID));

        menu.add(0, R.id.playqueue_play_now, 0, R.string.play_now);

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_to_playlist);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.playqueue_new_playlist, R.id.playqueue_selected_playlist);

        menu.add(0, R.id.playqueue_delete, 0, R.string.delete_item);

        menu.add(0, R.id.playqueue_info, 0, R.string.info);

        menu.add(0, R.id.playqueue_share_via, 0, R.string.share_via);

        // only add the 'search' menu if the selected item is music
        if (MusicUtils.isMusic(playQueueCursor)) {
            menu.add(0, R.id.playqueue_search_for, 0, R.string.search_for);
        }

        menu.setHeaderTitle(
                playQueueCursor.getString(playQueueCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.TITLE)));
    }

