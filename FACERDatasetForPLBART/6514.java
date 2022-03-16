        private void handleDocumentsProvider(ProviderInfo info) {
            // Ignore stopped packages for now; we might query them
            // later during UI interaction.
            if ((info.applicationInfo.flags & ApplicationInfo.FLAG_STOPPED) != 0) {
                if (LOGD) Log.d(TAG, "Ignoring stopped authority " + info.authority);
                mTaskStoppedAuthorities.add(info.authority);
                return;
            }

            // Try using cached roots if filtering
            boolean cacheHit = false;
            if (mFilterPackage != null && !mFilterPackage.equals(info.packageName)) {
                synchronized (mLock) {
                    if (mTaskRoots.putAll(info.authority, mRoots.get(info.authority))) {
                        if (LOGD) Log.d(TAG, "Used cached roots for " + info.authority);
                        cacheHit = true;
                    }
                }
            }

            // Cache miss, or loading everything
            if (!cacheHit) {
                mTaskRoots.putAll(info.authority,
                        loadRootsForAuthority(mContext.getContentResolver(), info.authority));
            }
        }

