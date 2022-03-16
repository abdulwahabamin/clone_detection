    public void compress(List<File> list, String out) {
        if (list.isEmpty()){
            Log.v(TAG, "couldn't compress empty file list");
            return;
        }
        this.fileOut = list.get(0).getParent()+File.separator+out;
        fileCount=0;
        for (File f: list){
            fileCount += FileUtils.getFileCount(f);
        }
        new CompressTask().execute(list);
    }

