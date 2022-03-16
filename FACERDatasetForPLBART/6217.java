        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            final State state = getDisplayState(DirectoryFragment.this);

            final MenuItem open = menu.findItem(R.id.menu_open);
            final MenuItem share = menu.findItem(R.id.menu_share);
            final MenuItem delete = menu.findItem(R.id.menu_delete);
            final MenuItem copy = menu.findItem(R.id.menu_copy);
            final MenuItem cut = menu.findItem(R.id.menu_cut);

            final boolean manageMode = state.action == ACTION_MANAGE;
            final boolean stdMode = state.action == ACTION_STANDALONE;
            open.setVisible(!manageMode && !stdMode);
            share.setVisible(manageMode || stdMode);
            delete.setVisible(manageMode || stdMode);
            copy.setVisible(stdMode);
            cut.setVisible(stdMode);

            return true;
        }

