    private void performIndexAction(String fileRoot) {
        Log.v(TAG, "performIndexAction(" + fileRoot + ")");
        if (TextUtils.isEmpty(fileRoot)) {
            Log.w(TAG, "Empty or null file root '" + fileRoot + "'");
            return;
        }
        Log.i(TAG, "Starting mime type usage indexing on '" + fileRoot + "'");
        fileRoot = fileRoot.trim();
        File rootFile = new File(fileRoot);
        Map<MimeTypeCategory, Long> spaceCalculationMap =
                new HashMap<MimeTypeCategory, Long>();
        calculateUsageByType(rootFile, spaceCalculationMap);
        ContentValues[] valuesList = new ContentValues[spaceCalculationMap.keySet().size()];
        int i = 0;
        for (MimeTypeCategory category : spaceCalculationMap.keySet()) {
            Log.d(TAG, "" + category + " = " + spaceCalculationMap.get(category));
            ContentValues values = new ContentValues();
            values.put(MimeTypeIndexProvider.COLUMN_FILE_ROOT, fileRoot);
            values.put(MimeTypeIndexProvider.COLUMN_CATEGORY, category.name());
            values.put(MimeTypeIndexProvider.COLUMN_SIZE, spaceCalculationMap.get(category));
            valuesList[i] = values;
            i++;
        }
        MimeTypeIndexProvider.clearMountPointUsages(this, fileRoot); // Clear old data
        getContentResolver().bulkInsert(MimeTypeIndexProvider.getContentUri(), valuesList);
    }

