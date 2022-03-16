    /**
     * Constructor of <code>ActionsDialog</code>.
     *
     * @param context The current context
     * @param fso The file system object associated
     * @param global If the menu to display will be the global one (Global actions)
     * @param search If the call is from search activity
     */
    public ActionsDialog(Context context, NavigationActivity backRef, FileSystemObject fso,
            boolean global, boolean search) {
        super();

        //Save the data
        this.mFso = fso;
        this.mContext = context;
        this.mBackRef = backRef;
        this.mGlobal = global;
        this.mSearch = search;
        this.mChRooted = FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) == 0;

        //Initialize dialog
        init(context, global ? R.id.mnu_actions_global : R.id.mnu_actions_fso);
    }

