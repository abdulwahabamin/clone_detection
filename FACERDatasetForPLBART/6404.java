    /**
     * Update a possibly stale restored stack against a live
     * {@link DocumentsProvider}.
     */
    public void updateDocuments(ContentResolver resolver) throws FileNotFoundException {
        for (DocumentInfo info : this) {
            info.updateSelf(resolver);
        }
    }

