    private static void calculateFileCount(File file){
        if (!file.isDirectory()){
            fileCount++;
            return;
        }
        if (file.list() == null){
            return;
        }
        for (String fileName: file.list()){
            File f = new File(file.getAbsolutePath()+File.separator+fileName);
            calculateFileCount(f);
        }
    }    

