        @Override
        public List<DocumentStack> loadInBackground(Uri uri, CancellationSignal signal) {
            final Collection<RootInfo> matchingRoots = mRoots.getMatchingRootsBlocking(mState);
            final ArrayList<DocumentStack> result = Lists.newArrayList();

            final ContentResolver resolver = getContext().getContentResolver();
            final Cursor cursor = resolver.query(
                    uri, null, null, null, RecentColumns.TIMESTAMP + " DESC", signal);
            try {
                while (cursor != null && cursor.moveToNext()) {
                    final byte[] rawStack = cursor.getBlob(
                            cursor.getColumnIndex(RecentColumns.STACK));
                    try {
                        final DocumentStack stack = new DocumentStack();
                        DurableUtils.readFromArray(rawStack, stack);

                        // Only update root here to avoid spinning up all
                        // providers; we update the stack during the actual
                        // restore. This also filters away roots that don't
                        // match current filter.
                        stack.updateRoot(matchingRoots);
                        result.add(stack);
                    } catch (IOException e) {
                        Log.w(TAG, "Failed to resolve stack: " + e);
                    }
                }
            } finally {
                IoUtils.closeQuietly(cursor);
            }

            return result;
        }

