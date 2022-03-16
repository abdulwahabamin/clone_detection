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
                return lhs.getName().compareTo(rhs.getName());
            }
        }
        else{
            if (!(lhs.isFile()^rhs.isFile())) {
                return lhs.getName().compareTo(rhs.getName());
            }
        }
        return 0;
    }

