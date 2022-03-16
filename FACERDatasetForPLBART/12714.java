    /**
     * Constructor of <code>InitialDirectoryDialog</code>.
     *
     * @param context The current context
     */
    public InitialDirectoryDialog(Context context) {
        super();

        //Save the context
        this.mContext = context;

        //Extract current value
        String value = Preferences.getSharedPreferences().getString(
                FileManagerSettings.SETTINGS_INITIAL_DIR.getId(),
                (String)FileManagerSettings.SETTINGS_INITIAL_DIR.getDefaultValue());

        //Create the layout
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout)li.inflate(R.layout.initial_directory, null);
        final View msgView = layout.findViewById(R.id.initial_directory_info_msg);
        final TextView labelView = (TextView)layout.findViewById(R.id.initial_directory_label);
        this.mAutocomplete =
                (DirectoryInlineAutocompleteTextView)layout.findViewById(
                        R.id.initial_directory_edittext);
        this.mAutocomplete.setOnValidationListener(
                new DirectoryInlineAutocompleteTextView.OnValidationListener() {
            @Override
            public void onVoidValue() {
                msgView.setVisibility(View.GONE);
                //The first invocation is valid. Can be ignore safely
                if (InitialDirectoryDialog.this.mDialog != null) {
                    InitialDirectoryDialog.this.mDialog.getButton(
                            DialogInterface.BUTTON_POSITIVE).setEnabled(false);
                }
            }
            @Override
            public void onValidValue() {
                msgView.setVisibility(View.GONE);
                //The first invocation is valid. Can be ignore safely
                if (InitialDirectoryDialog.this.mDialog != null) {
                    InitialDirectoryDialog.this.mDialog.getButton(
                            DialogInterface.BUTTON_POSITIVE).setEnabled(true);
                }
            }
            @Override
            public void onInvalidValue() {
                msgView.setVisibility(View.VISIBLE);
                //The first invocation is valid. Can be ignore safely
                if (InitialDirectoryDialog.this.mDialog != null) {
                    InitialDirectoryDialog.this.mDialog.getButton(
                            DialogInterface.BUTTON_POSITIVE).setEnabled(false);
                }
            }
        });
        this.mAutocomplete.setText(value);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, layout, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(context, labelView, "text_color"); //$NON-NLS-1$
        theme.setTextColor(context, (TextView)msgView, "text_color"); //$NON-NLS-1$
        ((TextView)msgView).setCompoundDrawablesWithIntrinsicBounds(
                theme.getDrawable(this.mContext,
                        "filesystem_dialog_warning_drawable"), //$NON-NLS-1$
                null, null, null);
        this.mAutocomplete.applyTheme();

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        0,
                                        R.string.initial_directory_dialog_title,
                                        layout);
        this.mDialog.setButton(
                DialogInterface.BUTTON_POSITIVE, context.getString(android.R.string.ok), this);
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE, context.getString(android.R.string.cancel), this);
    }

