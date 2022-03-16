    public BrowserSubListAdapter(Context context, BrowserSubListActivity activity,
                                 HashMap<Integer, String> dbColumnsMap) {
    	
        super(context, -1, activity.getCursor(), new String[] {}, new int[] {}, 0);
        mContext = context;
        mActivity = activity;
        mApp = (Common) mContext.getApplicationContext();
        mDBColumnsMap = dbColumnsMap;
        
    }

