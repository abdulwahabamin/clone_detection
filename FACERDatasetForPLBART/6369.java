    @Override
    public boolean apply(DocumentInfo doc) {
        if (doc.isDirectory()) {
            return true;
        }
        if (mimeMatches(mFilters, doc.mimeType)) {
            return true;
        }
        return false;
    }

