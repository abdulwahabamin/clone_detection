    public BlacklistedElementsAdapter(Context context, 
    								  ArrayList<String> elementsList, 
    								  ArrayList<String> artistsList,
    								  String MANAGER_TYPE) {
    	super(context, R.id.customize_screens_title, elementsList);
    	
    	mContext = context;
    	mElementsList = elementsList;
    	mArtistsList = artistsList;
        this.MANAGER_TYPE = MANAGER_TYPE;
        
    }

