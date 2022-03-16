        @Override
        protected Void doInBackground(Void... params) {
            final ContentResolver resolver = getContentResolver();
            ContentProviderClient client = null;

            int count = 0;
            for (DocumentInfo doc : mDocs) {
                try {
                    final DocumentInfo cwd = getCurrentDirectory();
                    client = DocumentsApplication.acquireUnstableProviderOrThrow(
                        resolver, cwd.derivedUri.getAuthority());

                    // Create a new file of the same MIME type as the original
                    final Uri childUri = DocumentsContract.createDocument(
                            client, cwd.derivedUri, doc.mimeType, doc.displayName);

                    ContentProviderClient.releaseQuietly(client);

                    if (childUri == null) {
                        Log.e(TAG, "Failed to create a new document (uri is null)");
                        continue;
                    }

                    final DocumentInfo copy = DocumentInfo.fromUri(resolver, childUri);

                    // Push data to the new file
                    copyFile(doc.derivedUri, copy.derivedUri);

                    // If we cut, delete the original file
                    if (!mIsCopy) {
                        DocumentsContract.deleteDocument(client, doc.derivedUri);
                    }

                    count++;
                    publishProgress((Integer) count);
                } catch (Exception e) {
                    Log.w(TAG, "Failed to copy " + doc, e);
                }
            }

            return null;
        }

