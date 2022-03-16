    public RecentFilesAdapter(Context context, Map<String,List<FileDirectory>> recentMap,
                              List<String> keyList,
                              RequestManager requestManager){
        this.context=context;
        this.recentMap=recentMap;
        this.keyList=keyList;
        this.requestManager=requestManager;
    }

