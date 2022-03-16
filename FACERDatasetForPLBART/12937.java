    /**
     * {@inheritDoc}
     */
    @Override
    public void startLoading() {
        //Show/Hide views
        this.post(new Runnable() {
            @Override
            public void run() {
                BreadcrumbView.this.mFilesystemInfo.setVisibility(View.INVISIBLE);
                BreadcrumbView.this.mDiskUsageInfo.setVisibility(View.INVISIBLE);
                BreadcrumbView.this.mLoadingDialog.show();
            }
        });
    }

