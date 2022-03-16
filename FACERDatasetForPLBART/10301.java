    /**
     * Method that removes a {@link FileSystemObject} from the view
     *
     * @param fso The file system object
     */
    public void removeItem(FileSystemObject fso) {
        // Delete also from internal list
        if (fso != null) {
            int cc = this.mFiles.size()-1;
            for (int i = cc; i >= 0; i--) {
                FileSystemObject f = this.mFiles.get(i);
                if (f != null && f.compareTo(fso) == 0) {
                    this.mFiles.remove(i);
                    break;
                }
            }
        }
        this.mAdapter.remove(fso);
    }

