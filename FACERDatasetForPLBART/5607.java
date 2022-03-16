    public UpdateDialog(Context context) {
        super(context, 
        		R.string.oi_distribution_update_box_text, 
        		R.string.oi_distribution_update_app, 
        		R.string.oi_distribution_update_checker_package, 
        		R.string.oi_distribution_update_checker_website);
        mContext = context;

        String version = VersionUtils.getVersionNumber(mContext);
        String appname = VersionUtils.getApplicationName(mContext);
        String appnameversion = mContext.getString(R.string.oi_distribution_name_and_version, appname, version);
        
        StringBuilder sb = new StringBuilder();
        sb.append(appnameversion);
        sb.append("\n\n");
        sb.append(mMessageText);
        setMessage(sb.toString());
        
        setButton(mContext.getText(R.string.oi_distribution_update_check_now), this);
    }

