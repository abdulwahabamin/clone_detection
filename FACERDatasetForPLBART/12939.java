    /**
     * {@inheritDoc}
     */
    @Override
    public void changeBreadcrumbPath(final String newPath, final boolean chRooted) {
        //Sets the current path
        this.mCurrentPath = newPath;

        //Update the mount point information
        updateMountPointInfo();

        //Remove all views
        this.mBreadcrumbBar.removeAllViews();

        // The first is always the root (except if we are in a ChRooted environment)
        if (!chRooted) {
            this.mBreadcrumbBar.addView(createBreadcrumbItem(new File(FileHelper.ROOT_DIRECTORY)));
        }

        //Add the rest of the path
        String[] dirs = newPath.split(File.separator);
        int cc = dirs.length;
        if (chRooted) {
            boolean first = true;
            for (int i = 1; i < cc; i++) {
                File f = createFile(dirs, i);
                if (StorageHelper.isPathInStorageVolume(f.getAbsolutePath())) {
                    if (!first) {
                        this.mBreadcrumbBar.addView(createItemDivider());
                    }
                    first = false;
                    this.mBreadcrumbBar.addView(createBreadcrumbItem(f));
                }
            }
        } else {
            for (int i = 1; i < cc; i++) {
                this.mBreadcrumbBar.addView(createItemDivider());
                this.mBreadcrumbBar.addView(createBreadcrumbItem(createFile(dirs, i)));
            }
        }

        // Now apply the theme to the breadcrumb
        applyTheme();

        //Set scrollbar at the end
        this.mScrollView.post(new Runnable() {
            @Override
            public void run() {
                BreadcrumbView.this.mScrollView.fullScroll(View.FOCUS_RIGHT);
            }
        });
    }

