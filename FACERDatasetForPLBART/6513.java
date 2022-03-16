        @Override
        protected Void doInBackground(Void... params) {
            final long start = SystemClock.elapsedRealtime();

            mTaskRoots.put(mRecentsRoot.authority, mRecentsRoot);

            final ContentResolver resolver = mContext.getContentResolver();
            final PackageManager pm = mContext.getPackageManager();

            // Pick up provider with action string
            final Intent intent = new Intent(DocumentsContract.PROVIDER_INTERFACE);
            final List<ResolveInfo> providers = pm.queryIntentContentProviders(intent, 0);
            for (ResolveInfo info : providers) {
                handleDocumentsProvider(info.providerInfo);
            }

            final long delta = SystemClock.elapsedRealtime() - start;
            Log.d(TAG, "Update found " + mTaskRoots.size() + " roots in " + delta + "ms");
            synchronized (mLock) {
                mRoots = mTaskRoots;
                mStoppedAuthorities = mTaskStoppedAuthorities;
            }
            mFirstLoad.countDown();
            resolver.notifyChange(sNotificationUri, null, false);
            return null;
        }

