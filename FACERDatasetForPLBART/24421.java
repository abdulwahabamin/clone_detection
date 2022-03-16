    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfoIn) {
        if (service == null) return;

        SubMenu sub = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, R.string.add_to_playlist);
        MusicUtils.makePlaylistMenu(getActivity(), sub, R.id.playerheader_new_playlist, R.id.playerheader_selected_playlist);

        menu.add(0, R.id.playerheader_delete, 0, R.string.delete_item);

        menu.add(0, R.id.playerheader_info, 0, R.string.info);

        menu.add(0, R.id.playerheader_share_via, 0, R.string.share_via);

        menu.add(0, R.id.playerheader_search_for, 0, R.string.search_for);

        menu.setHeaderTitle(service.getTrackName());
    }

