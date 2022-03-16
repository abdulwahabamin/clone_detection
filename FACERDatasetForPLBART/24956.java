        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.add_to_playlist_menu_item) {
                DialogHelper.addSongToPlaylist(PlaylistActivity.this);
                return true;
            } else if (i == R.id.remove_playlist_menu_item) {
                removeSongs();
                return true;
            } else {
                return false;
            }
        }

