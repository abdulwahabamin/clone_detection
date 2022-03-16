    /**
     * Constructor of <code>FsoPropertiesDialog</code>.
     *
     * @param context The current context
     * @param fso The file system object reference
     */
    public FsoPropertiesDialog(Context context, FileSystemObject fso) {
        super();

        //Save the context
        this.mContext = context;

        //Save data
        this.mFso = fso;
        this.mHasChanged = false;
        this.mIgnoreCheckEvents = true;
        this.mHasPrivileged = false;
        this.mIsAdvancedMode =
                FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) != 0;

        //Inflate the content
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContentView = li.inflate(R.layout.fso_properties_dialog, null);

        // Apply current theme
        applyTheme();

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        R.string.fso_properties_dialog_title,
                                        this.mContentView);
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                this.mContext.getString(android.R.string.ok),
                (DialogInterface.OnClickListener)null);
        this.mDialog.setOnCancelListener(this);
        this.mDialog.setOnDismissListener(this);

        // Retrieve the user settings about computing folder statistics
        this.mComputeFolderStatistics =
                Preferences.getSharedPreferences().
                    getBoolean(
                        FileManagerSettings.SETTINGS_COMPUTE_FOLDER_STATISTICS.getId(),
                        ((Boolean)FileManagerSettings.SETTINGS_COMPUTE_FOLDER_STATISTICS.
                                getDefaultValue()).booleanValue());

        //Fill the dialog
        fillData(this.mContentView);
    }

