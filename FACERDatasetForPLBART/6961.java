    @Override
    public int compare(File lhs, File rhs) {
        if(frist){
            if((!lhs.isFile() && rhs.isFile())){
                return -1;
            }
            if(lhs.isFile() && !rhs.isFile()){
                return 1;
            }
        }
        else{
            if(!lhs.isFile()&&rhs.isFile()){
                return 1;
            }
            if(lhs.isFile()&&!rhs.isFile()){
                return -1;
            }
        }

        if(second){
            if(!(lhs.isFile()^rhs.isFile())){
                return -Long.compare(lhs.lastModified(),rhs.lastModified());
            }
        }
        else{
            if (!(lhs.isFile()^rhs.isFile())) {
                return Long.compare(lhs.lastModified(),rhs.lastModified());
            }
        }
        return 0;
    }

