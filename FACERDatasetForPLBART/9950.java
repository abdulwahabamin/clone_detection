    /**
     * Constructor of <code>MessageProgressDialog</code>.
     *
     *
     * @param context The current context
     * @param iconResourceId The icon dialog resource identifier
     * @param titleResourceId The title dialog resource identifier
     * @param labelResourceId The label resource identifier
     * @param cancellable If the dialog is cancellable
     */
    public MessageProgressDialog(
            Context context, int iconResourceId,
            int titleResourceId, int labelResourceId, boolean cancellable) {
        this(context, iconResourceId, titleResourceId,
                context.getResources().getString(labelResourceId), cancellable);
    }

