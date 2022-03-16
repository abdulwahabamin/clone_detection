    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Uri url, String where, String[] whereArgs) {
        SQLiteDatabase db = this.mOpenHelper.getWritableDatabase();
        int count;
        String whereQuery = where;
        switch (sURLMatcher.match(url)) {
            case BOOKMARKS:
                count = db.delete("bookmarks", whereQuery, whereArgs); //$NON-NLS-1$
                break;
            case BOOKMARKS_ID:
                String segment = url.getPathSegments().get(1);
                if (TextUtils.isEmpty(whereQuery)) {
                    whereQuery = "_id=" + segment; //$NON-NLS-1$
                } else {
                    whereQuery = "_id=" + segment + //$NON-NLS-1$
                                 " AND (" + whereQuery + ")"; //$NON-NLS-1$ //$NON-NLS-2$
                }
                count = db.delete("bookmarks", whereQuery, whereArgs); //$NON-NLS-1$
                break;
            default:
                throw new IllegalArgumentException("Cannot delete from URL: " + url); //$NON-NLS-1$
        }

        getContext().getContentResolver().notifyChange(url, null);
        return count;
    }

