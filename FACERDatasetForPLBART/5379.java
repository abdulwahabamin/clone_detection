    public static String getProcessedPath(String path){
        StringBuilder processedPath=new StringBuilder("");
        String[] dirs=path.split("/");
        if(dirs.length<=3){
            return "";
        }
        for(int i=0;i<dirs.length;i++){
            if(i>2){
                processedPath.append(dirs[i]+"/");
            }
        }
        return processedPath.substring(0,processedPath.length()-1);
    }

