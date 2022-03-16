    /**
     * Update a possibly stale restored document against a live
     * {@link DocumentsProvider}.
     */
    public void updateSelf(ContentResolver resolver) throws FileNotFoundException {
        updateFromUri(resolver, derivedUri);
    }

