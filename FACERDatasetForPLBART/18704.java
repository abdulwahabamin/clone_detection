    public FileExtensionFilter(String[] extensions) {
        int length = extensions.length;
        this.extensions = new char[length][];
        
        for (String s : extensions) {
            this.extensions[--length] = s.toCharArray();
        }
        
    }

