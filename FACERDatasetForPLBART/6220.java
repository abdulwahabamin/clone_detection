        @Override
        public void onItemCheckedStateChanged(
                ActionMode mode, int position, long id, boolean checked) {
            if (checked) {
                // Directories and footer items cannot be checked
                boolean valid = false;
                boolean hasFolder = false;

                final Cursor cursor = mAdapter.getItem(position);
                if (cursor != null) {
                    final String docMimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
                    final int docFlags = getCursorInt(cursor, Document.COLUMN_FLAGS);
                    final State state = getDisplayState(DirectoryFragment.this);
                    if (Document.MIME_TYPE_DIR.equals(docMimeType)) {
                        hasFolder = true;
                    }
                    if (!Document.MIME_TYPE_DIR.equals(docMimeType) || state.action == ACTION_STANDALONE) {
                        valid = isDocumentEnabled(docMimeType, docFlags);
                    }
                }

                if (hasFolder) {
                    final Menu menu = mode.getMenu();
                    final MenuItem copy = menu.findItem(R.id.menu_copy);
                    final MenuItem cut = menu.findItem(R.id.menu_cut);
                    copy.setVisible(false);
                    cut.setVisible(false);
                }

                if (!valid) {
                    mCurrentView.setItemChecked(position, false);
                }
            }

            mode.setTitle(getResources()
                    .getString(R.string.mode_selected_count, mCurrentView.getCheckedItemCount()));
        }

