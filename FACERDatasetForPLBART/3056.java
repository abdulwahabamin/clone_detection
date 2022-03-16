    private void Paste(File file, File path) throws IOException {
        if(file == null){
            return;
        }
        if(file.isDirectory()){
            File d = new File(path.getPath()+"//"+file.getName());
            d.mkdir();
            File[] files = file.listFiles();
            for(File f:files) {
                Paste(f, d);
            }
        } else {
            Copy(file, path);
        }
    }

