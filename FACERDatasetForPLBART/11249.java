    /**
     * Method that returns the files of the adapter.
     *
     * @return List<FileSystemObject> The adapter data
     */
    public List<FileSystemObject> getFiles()  {
        final List<FileSystemObject> data = new ArrayList<FileSystemObject>();
        int N = getCount();
        for(int i = 0; i < N; i++) {
            data.add(getItem(i).getSearchResult().getFso());
        }
        return data;
    }

