    @Override
    public void onCreateSectionMenu(View view) {
        PopupMenu sectionMenu = new PopupMenu(getActivity(), view);
        sectionMenu.setOnMenuItemClickListener(this);
        Menu menu = sectionMenu.getMenu();

        if (isEditMode()) {
            menu.add(0, R.id.tracks_shuffle_playlist, 0, R.string.shuffleplaylist).setIcon(R.drawable.ic_menu_shuffle);
            menu.add(0, R.id.tracks_uniqueify_playlist, 0, R.string.uniqueifyplaylist).setIcon(R.drawable.ic_menu_uniqueify);
        }

        menu.add(0, R.id.tracks_play_all_now, 0, R.string.play_all_now).setIcon(R.drawable.ic_menu_play_clip);
        menu.add(0, R.id.tracks_play_all_next, 0, R.string.play_all_next).setIcon(R.drawable.ic_menu_play_clip);
        menu.add(0, R.id.tracks_queue_all, 0, R.string.queue_all).setIcon(R.drawable.ic_menu_play_clip);
        SubMenu interleave = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.interleave_all).setIcon(
                R.drawable.ic_menu_interleave);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                Intent intent = new Intent();
                intent.putExtra(CURRENT_COUNT, i);
                intent.putExtra(NEW_COUNT, j);
                interleave.add(2, R.id.tracks_interleave_all, 0, getResources().getString(R.string.interleaveNNN, i, j)).setIntent(intent);
            }
        }

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_all_to_playlist).setIcon(R.drawable.ic_menu_add);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.tracks_new_playlist, R.id.tracks_selected_playlist);

        if (!isPlaylist) {
            menu.add(0, R.id.tracks_delete_all, 0, R.string.delete_all).setIcon(R.drawable.ic_menu_delete);
        }

        CharSequence title = getActivity().getTitle();
        if (isMedadataCategory && title != null && !title.equals(MediaStore.UNKNOWN_STRING)) {
            menu.add(0, R.id.tracks_search_for_category, 0, R.string.search_for).setIcon(R.drawable.ic_menu_search);
        }

        if (playlist == MusicContract.Playlist.RECENTLY_ADDED_PLAYLIST) {
            menu.add(0, R.id.tracks_edit_playlist, 0, R.string.edit_playlist_menu);
        }

        if (playlist >= 0) {
            menu.add(0, R.id.tracks_export_playlist, 0, R.string.export_playlist_menu);
            menu.add(0, R.id.tracks_share_playlist, 0, R.string.share_via);
        }

        sectionMenu.show();
    }

