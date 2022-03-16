    /**
     * Constructor of <code>InputNameDialog</code>.
     *
     * @param context The current context
     * @param files The files of the current directory (used to validate the name)
     * @param fso The original file system object. null if not needed.
     * @param allowFsoName If allow that the name of the fso will be returned
     * @param dialogTitle The dialog title
     */
    public InputNameDialog(
            final Context context,
            final String parent,
            final FileSystemObject fso,
            boolean allowFsoName,
            final String dialogTitle) {
        super();

        //Save the context
        this.mContext = context;

        //Save the files
        this.mParent = parent;
        this.mFso = fso;
        this.mAllowFsoName = allowFsoName;
        this.mCancelled = true;

        //Create the
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.input_name_dialog, null);
        TextView title = (TextView)v.findViewById(R.id.input_name_dialog_label);
        title.setText(R.string.input_name_dialog_label);
        this.mEditText = (EditText)v.findViewById(R.id.input_name_dialog_edit);
        if (this.mFso != null) {
            this.mEditText.setText(this.mFso.getName());
        } else {
            this.mEditText.setText(dialogTitle);
        }
        this.mEditText.selectAll();
        this.mEditText.addTextChangedListener(this);
        this.mMsg = (TextView)v.findViewById(R.id.input_name_dialog_message);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, v, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(context, title, "text_color"); //$NON-NLS-1$
        theme.setTextColor(context, this.mMsg, "text_color"); //$NON-NLS-1$
        this.mMsg.setCompoundDrawablesWithIntrinsicBounds(
                theme.getDrawable(this.mContext,
                        "filesystem_dialog_warning_drawable"), //$NON-NLS-1$
                null, null, null);

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        dialogTitle,
                                        v);
        this.mDialog.setButton(
                DialogInterface.BUTTON_POSITIVE,
                context.getString(android.R.string.ok),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        InputNameDialog.this.mCancelled = false;
                    }
                });
        this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                InputMethodManager mgr =
                        (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.showSoftInput(InputNameDialog.this.mEditText, InputMethodManager.SHOW_IMPLICIT);
            }
        });
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                context.getString(android.R.string.cancel),
                (DialogInterface.OnClickListener)null);
        this.mDialog.setOnCancelListener(this);
        this.mDialog.setOnDismissListener(this);

        // Disable accept button, because name is the same as fso
        if (this.mFso != null && !this.mAllowFsoName) {
            this.mEditText.post(new Runnable() {
                @Override
                public void run() {
                    InputNameDialog.this.mDialog.getButton(
                            DialogInterface.BUTTON_POSITIVE).setEnabled(false);
                }
            });
        } else {
            this.mEditText.post(new Runnable() {
                @Override
                public void run() {
                    checkName(InputNameDialog.this.mEditText.getText().toString());
                }
            });
        }
    }

