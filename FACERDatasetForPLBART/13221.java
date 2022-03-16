    /**
     * Method that returns the Android IDs (system + application AID)
     *
     * @param context The current context
     * @param force Force the reload of the AIDs
     * @return SparseArray<AID> The array of {@link AID}
     */
    public synchronized static SparseArray<AID> getAIDs(Context context, boolean force) {
        if (sAids == null || force) {
            Properties systemAIDs = null;
            try {
                // Load the default known system identifiers
                systemAIDs = new Properties();
                systemAIDs.load(context.getResources().openRawResource(R.raw.aid));
            } catch (Exception e) {
                Log.e(TAG, "Fail to load AID raw file.", e); //$NON-NLS-1$
                return null;
            }

            // Add the default known system identifiers
            SparseArray<AID> aids = new SparseArray<AID>();
            Iterator<Object> it = systemAIDs.keySet().iterator();
            while (it.hasNext()) {
                String key = (String)it.next();
                String value = systemAIDs.getProperty(key);
                int uid = Integer.parseInt(key);
                aids.put(uid, new AID(uid, value));
            }

            // Now, retrieve all AID of installed applications
            final PackageManager pm = context.getPackageManager();
            List<ApplicationInfo> packages =
                    pm.getInstalledApplications(PackageManager.GET_META_DATA);
            int cc = packages.size();
            for (int i = 0; i < cc; i++) {
                ApplicationInfo info = packages.get(i);
                int uid = info.uid;
                if (aids.indexOfKey(uid) < 0) {
                    String name = pm.getNameForUid(uid);
                    aids.put(uid, new AID(uid, name));
                }
            }

            // Save to cached aids
            sAids = aids;
        }

        // Return the list of AIDs found
        return sAids;
    }

