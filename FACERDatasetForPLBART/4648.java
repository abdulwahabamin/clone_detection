    public final List<FileItem> getClipboardCopyFilesAsList() {
        List<FileItem> clip = new ArrayList<FileItem>();
        Iterator<FileItem> files= getClipboardCopyFiles().values().iterator();
        while(files.hasNext()) {

            clip.add(files.next());
            //BLog.e("ADD: " +clip.get(clip.size()-1).getAbsolutePath());
        }
        return clip;
    }

