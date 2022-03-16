    @Override
    public void onClearCache(Object o) {
        if (o instanceof FileSystemObject && mAdapter != null) {
            mAdapter.clearCache((FileSystemObject)o);
        }
    }

