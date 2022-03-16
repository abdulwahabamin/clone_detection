    public static int indexFile(FileItem file) {
        int iconfile = Files.getFileRIcon(file.getAbsolutePath());
        long mdoified = file.getAbsoluteFile().lastModified();
        int category = getCategory(iconfile,file.getName());
        if(file.exists() && category!=Files.CAT_UNKNOWN) {
            File f= file.getAbsoluteFile();
            IndexerFile ifile = new IndexerFile(0,file.getName(),file.getParentFile().getAbsolutePath(),category,f.length(),iconfile,f.lastModified());
            if(IndexerDb.getDb()==null)
                IndexerDb.init(IND.context);
            FileItem fit = ifile.getAsFileItem();
            if(!IndexerDb.has(file.getName(), file.getParentFile().getAbsolutePath())) {
                //Log.e("INDS", "add file: " + fit.toString() + " -- " + fit.icon);
                IndexerDb.add(ifile);
            } else {
                //Log.e("INDS", "!!!!!!!!!!!!!! UPDATE --  file: " + fit.toString() + " -- " + fit.icon);
                IndexerDb.update(ifile);
            }

            return 1;
        }
        return 0;
    }

