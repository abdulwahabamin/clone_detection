    public boolean addSelectedFile(FileItem f) {
        //FileItem fi=new FileItem(f.getName(), Files.getFileRIcon(f.getName()),f.getPath());
        selectedFiles.put(f.getAbsolutePath(), f);

        return true;
    }

