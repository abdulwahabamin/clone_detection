    void createScrollList(){
        scrollList=new String[fileDirectories.size()];
        for(int i=0;i<fileDirectories.size();i++){
            scrollList[i]=fileDirectories.get(i).getName().toUpperCase().charAt(0)+"";
        }
    }

