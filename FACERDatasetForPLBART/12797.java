    /**
     * Method that check if is needed to prompt the user for overwrite prior to do
     * the operation.
     *
     * @param files The list of source/destination files.
     * @param currentFiles The list of the current files in the destination directory.
     * @return boolean If is needed to prompt the user for overwrite
     */
    private static boolean isOverwriteNeeded(
            List<LinkedResource> files, List<FileSystemObject> currentFiles) {
        boolean askUser = false;
        int cc = currentFiles.size();
        for (int i = 0; i < cc; i++) {
            int cc2 = files.size();
            for (int j = 0; j < cc2; j++) {
                FileSystemObject dst1 =  currentFiles.get(i);
                File dst2 = files.get(j).mDst;

                // The file exists in the destination directory
                if (dst1.getFullPath().compareTo(dst2.getAbsolutePath()) == 0) {
                    askUser = true;
                    break;
                }
            }
            if (askUser) break;
        }
        return askUser;
    }

