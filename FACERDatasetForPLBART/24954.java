        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            if (contentType != ContentType.PLAYLIST) {
                mode.getMenuInflater().inflate(R.menu.song_selection_menu, menu);
            } else {
                mode.getMenuInflater().inflate(R.menu.song_remove_menu, menu);
            }
            return true;
        }

