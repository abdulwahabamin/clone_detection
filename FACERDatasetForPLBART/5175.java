    void getCrumbList(String path){
        path=path.substring(1,path.length());
        String[] paths=path.split("/");
        for(String crumb:paths)
            crumbList.add(crumb);
    }

