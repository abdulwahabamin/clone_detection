    /**
     * {@inheritDoc}
     */
    @Override
    public String getType(Uri url) {
        int match = sURLMatcher.match(url);
        switch (match) {
            case BOOKMARKS:
                return "vnd.android.cursor.dir/bookmarks"; //$NON-NLS-1$
            case BOOKMARKS_ID:
                return "vnd.android.cursor.item/bookmarks"; //$NON-NLS-1$
            case HISTORY:
                return "vnd.android.cursor.dir/history"; //$NON-NLS-1$
            case HISTORY_ID:
                return "vnd.android.cursor.item/history"; //$NON-NLS-1$
            default:
                throw new IllegalArgumentException("Unknown URL"); //$NON-NLS-1$
        }
    }

