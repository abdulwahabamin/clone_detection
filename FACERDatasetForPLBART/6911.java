    public File[] setfiledata(ArrayList<File> data) {
        this.filedata = data;
        sort();
        this.notifyDataSetChanged();
        File[] files = new File[filedata.size()];
        int j=0;
        for (int i = 0; i < files.length; i++) {
            File file=filedata.get(i);
            if(!file.isHidden()){
                files[j]=file;
                j++;
            }
        }
        return files;
    }

