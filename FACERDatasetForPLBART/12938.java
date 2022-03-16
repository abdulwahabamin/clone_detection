    /**
     * {@inheritDoc}
     */
    @Override
    public void endLoading() {
        //Show/Hide views
        this.post(new Runnable() {
            @Override
            public void run() {
                BreadcrumbView.this.mLoadingDialog.dismiss();
                BreadcrumbView.this.mFilesystemInfo.setVisibility(View.VISIBLE);
                BreadcrumbView.this.mDiskUsageInfo.setVisibility(View.VISIBLE);
            }
        });
    }

