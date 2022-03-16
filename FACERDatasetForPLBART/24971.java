        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.delete_playlist_menu_item) {
                deletePlaylist();
                actionMode.finish();
                return true;
            } else {
                return false;
            }
        }

