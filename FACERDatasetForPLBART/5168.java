    public static List<FileItem> getStopZipFiles(List<FileItem> files) {
        List<FileItem> stopfiles=new ArrayList<FileItem>();

        HashMap<String,Boolean> uniqueFilenames=new HashMap<String,Boolean>();
        for(FileItem f: files) {
            if(uniqueFilenames.get(f.getName())==null) {
                uniqueFilenames.put(f.getName(),Boolean.TRUE);
            } else {
                stopfiles.add(f);
            }
        }
        // check ok folders

        return stopfiles;

    }

