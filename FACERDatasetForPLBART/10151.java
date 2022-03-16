    /**
     * {@inheritDoc}
     */
    @Override
    public void endLoading() {
        //Show/Hide views
        this.post(new Runnable() {
            @Override
            public void run() {
                BreadcrumbView.this.mLoading.setVisibility(View.INVISIBLE);
                BreadcrumbView.this.mFilesystemInfo.setVisibility(View.VISIBLE);
                BreadcrumbView.this.mDiskUsageInfo.setVisibility(View.VISIBLE);
            }
        });
    }

