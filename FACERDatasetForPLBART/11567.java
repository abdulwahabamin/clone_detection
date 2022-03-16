    /**
     * Method that search files recursively
     *
     * @param folder The folder where to start the search
     */
    private void findRecursive(TFile folder) {
        // Obtains the files and folders of the folders
        TFile[] files = folder.listFiles();
        if (files != null) {
            int cc = files.length;
            for (int i = 0; i < cc; i++) {
                if (files[i].isDirectory()) {
                    findRecursive(files[i]);
                }

                // Check if the file or folder matches the regexp
                try {
                    int ccc = this.mQueryRegExp.length;
                    for (int j = 0; j < ccc; j++) {
                        if (files[i].getName().matches(this.mQueryRegExp[j])) {
                            FileSystemObject fso = FileHelper.createFileSystemObject(files[i]);
                            if (fso != null) {
                                // Convert to virtual
                                fso.setParent(getConsole().buildVirtualPath(
                                        files[i].getParentFile()));
                                fso.setSecure(true);

                                if (isTrace()) {
                                    Log.v(TAG, String.valueOf(fso));
                                }
                                if (this.mAsyncResultListener != null) {
                                    this.mAsyncResultListener.onPartialResult(fso);
                                }
                            }
                        }
                    }
                } catch (Exception e) {/**NON-BLOCK**/}

                // Check if the process was cancelled
                try {
                    synchronized (this.mSync) {
                        if (this.mCancelled  || this.mEnded || (mAsyncResultListener != null
                                && mAsyncResultListener.isCancelled())) {
                            this.mSync.notify();
                            break;
                        }
                    }
                } catch (Exception e) {/**NON BLOCK**/}
            }
        }
    }

