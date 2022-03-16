    /**
     * Gather roots from storage providers belonging to given authority.
     */
    public void updateAuthorityAsync(String authority) {
        final ProviderInfo info = mContext.getPackageManager().resolveContentProvider(authority, 0);
        if (info != null) {
            updatePackageAsync(info.packageName);
        }
    }

