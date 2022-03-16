    /**
     * Method that initializes the dialog.
     *
     * @param context The current context
     * @param icon The icon of the dialog
     * @param title The title of the dialog
     * @param action The title of the action button
     * @param onCancelListener The cancel listener
     * @param onCancelListener The dismiss listener
     */
    private void init(int icon, String title, String action,
            OnCancelListener onCancelListener, OnDismissListener onDismissListener) {
        boolean isPlatformSigned = AndroidHelper.isAppPlatformSignature(this.mContext);

        //Create the layout, and retrieve the views
        LayoutInflater li =
                (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(R.layout.associations_dialog, null, false);
        this.mRemember = (CheckBox)v.findViewById(R.id.associations_remember);
        this.mRemember.setVisibility(
                isPlatformSigned && this.mAllowPreferred ? View.VISIBLE : View.GONE);
        this.mGrid = (GridView)v.findViewById(R.id.associations_gridview);
        mGrid.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
        AssociationsAdapter adapter =
                new AssociationsAdapter(this.mContext, this.mGrid, this.mIntents, this);
        this.mGrid.setAdapter(adapter);

        // Ensure a default title dialog
        String dialogTitle = title;
        if (dialogTitle == null) {
            dialogTitle = this.mContext.getString(R.string.associations_dialog_title);
        }

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(this.mContext);
        theme.setBackgroundDrawable(this.mContext, v, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(this.mContext, this.mRemember, "text_color"); //$NON-NLS-1$

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        this.mContext,
                                        icon,
                                        dialogTitle,
                                        v);
        this.mDialog.setButton(
                DialogInterface.BUTTON_POSITIVE,
                action,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ResolveInfo ri = getSelected();
                        Intent intent =
                                IntentsActionPolicy.getIntentFromResolveInfo(
                                        ri, AssociationsDialog.this.mRequestIntent);

                        // Open the intent (and remember the action is the check is marked)
                        onIntentSelected(
                                ri,
                                intent,
                                AssociationsDialog.this.mRemember.isChecked());
                    }
                });
        this.mDialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                this.mContext.getString(android.R.string.cancel),
                (DialogInterface.OnClickListener)null);
        this.mDialog.setOnCancelListener(onCancelListener);
        this.mDialog.setOnDismissListener(onDismissListener);
    }

