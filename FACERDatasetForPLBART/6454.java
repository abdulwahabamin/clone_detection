    @Override
    public DirectoryResult loadInBackground() {
        if (mFirstPassLatch == null) {
            // First time through we kick off all the recent tasks, and wait
            // around to see if everyone finishes quickly.

            final Collection<RootInfo> roots = mRoots.getMatchingRootsBlocking(mState);
            for (RootInfo root : roots) {
                if ((root.flags & Root.FLAG_SUPPORTS_RECENTS) != 0) {
                    final RecentTask task = new RecentTask(root.authority, root.rootId);
                    mTasks.put(root, task);
                }
            }

            mFirstPassLatch = new CountDownLatch(mTasks.size());
            for (RecentTask task : mTasks.values()) {
                ProviderExecutor.forAuthority(task.authority).execute(task);
            }

            try {
                mFirstPassLatch.await(MAX_FIRST_PASS_WAIT_MILLIS, TimeUnit.MILLISECONDS);
                mFirstPassDone = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        final long rejectBefore = System.currentTimeMillis() - REJECT_OLDER_THAN;

        // Collect all finished tasks
        boolean allDone = true;
        List<Cursor> cursors = Lists.newArrayList();
        for (RecentTask task : mTasks.values()) {
            if (task.isDone()) {
                try {
                    final Cursor cursor = task.get();
                    if (cursor == null) continue;

                    final FilteringCursorWrapper filtered = new FilteringCursorWrapper(
                            cursor, mState.acceptMimes, RECENT_REJECT_MIMES, rejectBefore) {
                        @Override
                        public void close() {
                            // Ignored, since we manage cursor lifecycle internally
                        }
                    };
                    cursors.add(filtered);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    // We already logged on other side
                }
            } else {
                allDone = false;
            }
        }

        if (LOGD) {
            Log.d(TAG, "Found " + cursors.size() + " of " + mTasks.size() + " recent queries done");
        }

        final DirectoryResult result = new DirectoryResult();
        result.sortOrder = SORT_ORDER_LAST_MODIFIED;

        // Hint to UI if we're still loading
        final Bundle extras = new Bundle();
        if (!allDone) {
            extras.putBoolean(DocumentsContract.EXTRA_LOADING, true);
        }

        final Cursor merged;
        if (cursors.size() > 0) {
            merged = new MergeCursor(cursors.toArray(new Cursor[cursors.size()]));
        } else {
            // Return something when nobody is ready
            merged = new MatrixCursor(new String[0]);
        }

        final SortingCursorWrapper sorted = new SortingCursorWrapper(merged, result.sortOrder) {
            @Override
            public Bundle getExtras() {
                return extras;
            }
        };

        result.cursor = sorted;

        return result;
    }

