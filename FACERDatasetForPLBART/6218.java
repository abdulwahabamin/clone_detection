        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            final SparseBooleanArray checked = mCurrentView.getCheckedItemPositions();
            final ArrayList<DocumentInfo> docs = Lists.newArrayList();
            final int size = checked.size();
            for (int i = 0; i < size; i++) {
                if (checked.valueAt(i)) {
                    final Cursor cursor = mAdapter.getItem(checked.keyAt(i));
                    final DocumentInfo doc = DocumentInfo.fromDirectoryCursor(cursor);
                    docs.add(doc);
                }
            }

            final int id = item.getItemId();
            if (id == R.id.menu_open) {
                DocumentsActivity.get(DirectoryFragment.this).onDocumentsPicked(docs);
                mode.finish();
                return true;

            } else if (id == R.id.menu_share) {
                onShareDocuments(docs);
                mode.finish();
                return true;

            } else if (id == R.id.menu_delete) {
                onDeleteDocuments(docs);
                mode.finish();
                return true;

            } else if (id == R.id.menu_copy) {
                onCopyDocuments(docs);
                mode.finish();
                return true;

            } else if (id == R.id.menu_cut) {
                onCutDocuments(docs);
                mode.finish();
                return true;

            } else {
                return false;
            }
        }

