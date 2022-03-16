        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Cursor cursor = mAdapter.getItem(position);
            if (cursor != null) {
                final String docMimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
                final int docFlags = getCursorInt(cursor, Document.COLUMN_FLAGS);
                if (isDocumentEnabled(docMimeType, docFlags)) {
                    final DocumentInfo doc = DocumentInfo.fromDirectoryCursor(cursor);
                    ((DocumentsActivity) getActivity()).onDocumentPicked(doc);
                }
            }
        }

