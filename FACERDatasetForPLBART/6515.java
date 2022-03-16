    /**
     * Bring up requested provider and query for all active roots.
     */
    private Collection<RootInfo> loadRootsForAuthority(ContentResolver resolver, String authority) {
        if (LOGD) Log.d(TAG, "Loading roots for " + authority);

        synchronized (mObservedAuthorities) {
            if (mObservedAuthorities.add(authority)) {
                // Watch for any future updates
                final Uri rootsUri = DocumentsContract.buildRootsUri(authority);
                mContext.getContentResolver().registerContentObserver(rootsUri, true, mObserver);
            }
        }

        final List<RootInfo> roots = Lists.newArrayList();
        final Uri rootsUri = DocumentsContract.buildRootsUri(authority);

        ContentProviderClient client = null;
        Cursor cursor = null;
        try {
            client = DocumentsApplication.acquireUnstableProviderOrThrow(resolver, authority);
            cursor = client.query(rootsUri, null, null, null, null);
            while (cursor.moveToNext()) {
                final RootInfo root = RootInfo.fromRootsCursor(authority, cursor);
                roots.add(root);
            }
        } catch (Exception e) {
            Log.w(TAG, "Failed to load some roots from " + authority + ": " + e);
        } finally {
            IoUtils.closeQuietly(cursor);
            ContentProviderClient.releaseQuietly(client);
        }
        return roots;
    }

