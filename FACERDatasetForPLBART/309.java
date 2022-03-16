    public void setFile(File file) {
        this.file = file;
        if(fileChangeListener != null) {
            fileChangeListener.onChange();
        }
    }

