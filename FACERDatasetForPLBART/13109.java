    /**
     * {@inheritDoc}
     */
    @Override
    public void onBreadcrumbItemClick(BreadcrumbItem item) {
        changeCurrentDir(item.getItemPath(), true, true, false, null, null);
    }

