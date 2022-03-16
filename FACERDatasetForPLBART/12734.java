    /**
     * Constructor of <code>MessageProgressDialog</code>.
     *
     *
     * @param context The current context
     * @param iconResourceId The icon dialog resource identifier
     * @param titleResourceId The title dialog resource identifier
     * @param labelMsg The label message
     * @param cancellable If the dialog is cancellable
     */
    public MessageProgressDialog(
            Context context, int iconResourceId,
            int titleResourceId, String labelMsg, boolean cancellable) {
        super();

        //Save the context
        this.mContext = context;

        //Create the layout
        LayoutInflater li =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup layout = (ViewGroup)li.inflate(R.layout.message_progress_dialog, null);
        final TextView labelView =
                (TextView)layout.findViewById(R.id.message_progress_dialog_label);
        labelView.setText(labelMsg);
        this.mProgress = (TextView)layout.findViewById(R.id.message_progress_dialog_progress);

        // Apply the current theme
        Theme theme = ThemeManager.getCurrentTheme(context);
        theme.setBackgroundDrawable(context, layout, "background_drawable"); //$NON-NLS-1$
        theme.setTextColor(context, labelView, "text_color"); //$NON-NLS-1$
        theme.setTextColor(context, this.mProgress, "text_color"); //$NON-NLS-1$

        //Create the dialog
        this.mDialog = DialogHelper.createDialog(
                                        context,
                                        iconResourceId,
                                        titleResourceId,
                                        layout);
        this.mDialog.setCancelable(cancellable);
        this.mDialog.setCanceledOnTouchOutside(false);
        if (cancellable) {
            this.mDialog.setButton(
                    DialogInterface.BUTTON_NEUTRAL, context.getString(android.R.string.cancel), this);
            this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    // Disable cancel button
                    MessageProgressDialog.this.mDialog.getButton(
                        DialogInterface.BUTTON_NEUTRAL).setEnabled(false);

                    // Wait for cancellation
                    if (MessageProgressDialog.this.mOnCancelListener != null) {
                        if (!MessageProgressDialog.this.mOnCancelListener.onCancel()) {
                            //The operation couldn't be cancelled
                            DialogHelper.showToast(
                                MessageProgressDialog.this.mContext,
                                R.string.msgs_operation_can_not_be_cancelled, Toast.LENGTH_SHORT);
                        }
                    }
                }
            });
        }

        //Initialize the progress
        this.mProgress.setText(null);
    }

