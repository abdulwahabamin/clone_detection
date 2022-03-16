    private boolean onDeleteDocumentsImpl(final List<DocumentInfo> docs) {
        final Context context = getActivity();
        final ContentResolver resolver = context.getContentResolver();

        boolean hadTrouble = false;
        for (DocumentInfo doc : docs) {
            if (!doc.isDeleteSupported()) {
                Log.w(TAG, "Skipping " + doc);
                hadTrouble = true;
                continue;
            }

            ContentProviderClient client = null;
            try {
                client = DocumentsApplication.acquireUnstableProviderOrThrow(
                        resolver, doc.derivedUri.getAuthority());

                if (Document.MIME_TYPE_DIR.equals(doc.mimeType)) {
                    // In order to delete a directory, we must delete its contents first. We
                    // recursively do so.
                    Uri contentsUri = DocumentsContract.buildChildDocumentsUri(
                        doc.authority, doc.documentId);
                    final RootInfo root = getArguments().getParcelable(EXTRA_ROOT);

                    // We get the contents of the directory
                    DirectoryLoader loader = new DirectoryLoader(
                            context, mType, root, doc, contentsUri, SORT_ORDER_UNKNOWN);

                    DirectoryResult result = loader.loadInBackground();
                    Cursor cursor = result.cursor;

                    // Build a list of the docs to delete, and delete them
                    ArrayList<DocumentInfo> docsToDelete = new ArrayList<DocumentInfo>();
                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        final DocumentInfo subDoc = DocumentInfo.fromDirectoryCursor(cursor);
                        docsToDelete.add(subDoc);
                    }

                    onDeleteDocumentsImpl(docsToDelete);
                }


                DocumentsContract.deleteDocument(client, doc.derivedUri);
            } catch (Exception e) {
                Log.w(TAG, "Failed to delete " + doc);
                hadTrouble = true;
            } finally {
                ContentProviderClient.releaseQuietly(client);
            }
        }

        return !hadTrouble;
    }

