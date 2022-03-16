    /**
     * Returns a subset of the search results falling into the given category
     * @param category MimeTypeCategory
     * @return list of FileSystemObjects that
     */
    private ArrayList<FileSystemObject> filterSearchResults(MimeTypeCategory category) {
        ArrayList<FileSystemObject> filteredList = new ArrayList<FileSystemObject>();

        if (mAdapter.getCount() < 1) return filteredList;

        for (FileSystemObject fso : mAdapter.getFiles()) {
            if (MimeTypeHelper.getCategoryFromExt(this,
                                                  FileHelper.getExtension(fso),
                                                  fso.getFullPath()) == category) {
                filteredList.add(fso);
            }
        }

        return filteredList;
    }

