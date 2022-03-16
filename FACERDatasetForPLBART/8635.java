    /**
     * Method that computes the folder usage recursively
     *
     * @param folder The folder where to start the computation
     */
    private void computeRecursive(File folder) {
        // Obtains the files and folders of the folders
        try {
            File[] files = folder.listFiles();
            int c = 0;
            if (files != null) {
                int cc = files.length;
                for (int i = 0; i < cc; i++) {
                    if (files[i].isDirectory()) {
                        this.mFolderUsage.addFolder();
                        computeRecursive(files[i]);
                    } else {
                        this.mFolderUsage.addFile();
                        // Compute statistics and size
                        File file = files[i];
                        String ext = FileHelper.getExtension(file.getName());
                        MimeTypeCategory category =
                                MimeTypeHelper.getCategoryFromExt(null,
                                                                  ext,
                                                                  file.getAbsolutePath());
                        this.mFolderUsage.addFileToCategory(category);
                        this.mFolderUsage.addSize(files[i].length());
                    }

                    // Partial notification
                    if (c % 5 == 0) {
                        //If a listener is defined, then send the partial result
                        if (getAsyncResultListener() != null) {
                            getAsyncResultListener().onPartialResult(this.mFolderUsage);
                        }
                    }

                    // Check if the process was cancelled
                    try {
                        synchronized (this.mSync) {
                            if (this.mCancelled  || this.mEnded) {
                                this.mSync.notify();
                                break;
                            }
                        }
                    } catch (Exception e) {/**NON BLOCK**/}
                }
            }
        } finally {
            //If a listener is defined, then send the partial result
            if (getAsyncResultListener() != null) {
                getAsyncResultListener().onPartialResult(this.mFolderUsage);
            }
        }
    }

