    List<FileDirectory> getTotalItems(){
        totalList.clear();
        for(String key:keyList){
            for(FileDirectory fileDirectory:recentMap.get(key))
                totalList.add(fileDirectory);
        }
        return totalList;
    }

