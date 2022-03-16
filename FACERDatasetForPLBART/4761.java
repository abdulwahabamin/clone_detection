    public static void refresh(Context context, final String hintFilePath, long when) {
        IND.indexQue.add(hintFilePath);
        if(IND.context==null)
            IND.context=context;
        if(!IND.isRunning) {
            IND.isRunning=true;
            IndexerDb.init(context);
            refreshKnownPaths(hintFilePath,when);
            IND.isRunning=false;

        }
    }

