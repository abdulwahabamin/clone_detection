    public boolean moveSelectedFilesToClipboard() {
        try {
            clipboardCopyFiles=selectedFiles;
            selectedFiles=new HashMap<String,FileItem>();
            return true;
        } catch(Exception e) {}
        return false;

    }

