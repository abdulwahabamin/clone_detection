    /**
     *
     * @param fileDirectoryList
     * List to process
     * @return
     */
    public static List<FileDirectory> timeRemovedList(List<FileDirectory> fileDirectoryList){
        for(int i=0;i<fileDirectoryList.size();i++){
            FileDirectory fileDirectory=fileDirectoryList.get(i);
            fileDirectoryList.get(i).setDate(fileDirectory.getDate().split(" ")[0]);
        }
        return fileDirectoryList;
    }

