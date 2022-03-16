    /**
     * {@inheritDoc}
     */
    @Override
    public void onClick(View v) {
        BreadcrumbItem item = (BreadcrumbItem)v;
        int cc = this.mBreadcrumbListeners.size();
        for (int i = 0; i < cc; i++) {
            this.mBreadcrumbListeners.get(i).onBreadcrumbItemClick(item);
        }
    }

