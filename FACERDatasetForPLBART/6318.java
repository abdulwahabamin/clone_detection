    public void setClipboardDocuments(List<DocumentInfo> docs, boolean copy) {
        mClipboardFiles = docs;
        mClipboardIsCopy = copy;
        final Resources r = getResources();
        Toast.makeText(this,
            r.getQuantityString(R.plurals.files_copied, docs.size(), docs.size()),
            Toast.LENGTH_SHORT).show();

        // Update the action bar buttons
        invalidateOptionsMenu();
    }

