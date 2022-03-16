    @Override
    public void onCursor(Cursor cursor) {
        if (cursor == null) {
            Log.w(TAG, "Cursor is null");
            return;
        }
        if (mDiskUsage == null) {
            Log.w(TAG, "No disk usage available!");
            return;
        }
        mDiskUsage.clearUsageCategories();
        while(cursor.moveToNext()) {
            String fileRoot = cursor.getString(cursor.getColumnIndex(MimeTypeIndexProvider
                    .COLUMN_FILE_ROOT));
            String categoryString = cursor.getString(cursor.getColumnIndex(MimeTypeIndexProvider
                    .COLUMN_CATEGORY));
            long size = cursor.getLong(cursor.getColumnIndex(MimeTypeIndexProvider.COLUMN_SIZE));
            MimeTypeCategory category = MimeTypeCategory.valueOf(categoryString);
            DiskUsageCategory usageCategory = new DiskUsageCategory(category, size);
            mDiskUsage.addUsageCategory(usageCategory);

            // [TODO][MSB]: Unhandled case: No data, sync in progress, ready to draw
            // * Should check if 0 length, then wait on uri notification?
            // ** This should only happen if you are using it without a sync ever having happened
            // ** before.
            // * Should always wait on uri notification and update drawing?
            // * Otherwise if we have data then we are good to go!
            // * Also should think of a way to dispatch and index refresh (alarm manager? file
            // ** observer?)

        }

        if (mIsInUsageTab) {
            if (mLegendLayout.getVisibility() != View.VISIBLE) {
                populateLegend();
                mLegendLayout.setVisibility(View.VISIBLE);
            }
        }

        this.mDiskUsageGraph.post(new Runnable() {
            @Override
            public void run() {
                //Animate disk usage graph
                FilesystemInfoDialog.this.mDiskUsageGraph.drawDiskUsage(mDiskUsage);
                isFetching = false;
            }
        });
    }

