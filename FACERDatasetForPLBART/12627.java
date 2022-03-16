    /**
     * Constructor of <code>AssociationsDialog</code>.
     *
     * @param context The current context
     * @param icon The icon of the dialog
     * @param title The title dialog
     * @param action The title of the action button
     * @param requestIntent The original request
     * @param intents The list of available intents that can handle an action
     * @param preferred The preferred intent. null if no preferred exists
     * @param allowPreferred If allow the user to mark the selected app as preferred
     * @param onCancelListener The cancel listener
     * @param onDismissListener The dismiss listener
     */
    public AssociationsDialog(
            Context context, int icon, String title, String action,
            Intent requestIntent, List<ResolveInfo> intents, ResolveInfo preferred,
            boolean allowPreferred, OnCancelListener onCancelListener,
            OnDismissListener onDismissListener) {
        super();

        //Save the data
        this.mContext = context;
        this.mRequestIntent = requestIntent;
        this.mIntents = intents;
        this.mPreferred = preferred;
        this.mAllowPreferred = allowPreferred;
        this.mLoaded = false;

        //Initialize dialog
        init(icon, title, action, onCancelListener, onDismissListener);
    }

