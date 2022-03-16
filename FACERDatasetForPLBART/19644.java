    public SettingsMultiselectAdapter(Context context,
                                      SettingsMusicFoldersDialog fragment,
                                      boolean welcomeSetup,
                                      boolean dirChecked) {
    	
    	super(context, -1, fragment.getFileFolderNamesList());
    	
    	mContext = context;
    	mApp = (Common) mContext.getApplicationContext();
    	mFragment = fragment;
    	mDirChecked = dirChecked; //Indicates if this entire dir is a music folder.
    	mWelcomeSetup = welcomeSetup;
    	
    }

