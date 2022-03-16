    public GetFromMarketDialog(Context context, int message, int buttontext, int market_uri, int developer_uri) {
        super(context);
        mContext = context;
        mMarketUri = market_uri;
        mDeveloperUri = developer_uri;

        //setTitle(context.getText(R.string.menu_edit_tags));
        setMessage(mContext.getText(message));
    	setButton(mContext.getText(buttontext), this);
        
    }

