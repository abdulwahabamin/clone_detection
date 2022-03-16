    @Override
    protected Cursor doInBackground(String... strings) {
        if (strings.length < 1) {
            return null;
        }
        String fileRoot = strings[0];
        return MimeTypeIndexProvider.getMountPointUsage(mContext, fileRoot);
    }

