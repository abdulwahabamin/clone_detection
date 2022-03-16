    public ListViewCardsAdapter(Context context, ListViewFragment listViewFragment, 
    					   		HashMap<Integer, String> dbColumnsMap) {
    	
        super(context, -1, listViewFragment.getCursor(), new String[] {}, new int[] {}, 0);
        mContext = context;
        mListViewFragment = listViewFragment;
        mApp = (Common) mContext.getApplicationContext();
        mDBColumnsMap = dbColumnsMap;
        
    }

