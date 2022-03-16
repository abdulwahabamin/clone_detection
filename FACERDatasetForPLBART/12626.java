    private boolean containsSecureDirectory(List<FileSystemObject> selection) {
        if (mFso != null && FileHelper.isDirectory(mFso) && mFso.isSecure()) {
            return true;
        }

        if (selection == null) {
            return false;
        }

        for (FileSystemObject fso : selection) {
            if (FileHelper.isDirectory(fso) && fso.isSecure()) {
                return true;
            }
        }

        return false;
    }

