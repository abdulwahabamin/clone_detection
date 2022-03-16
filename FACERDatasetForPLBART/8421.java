    /**
     * Constructor of <code>CheckableListAdapter</code>.
     *
     * @param context The current context
     * @param items An array of items to add to the current list
     * @param isDialog Indicates if the owner is a dialog (not a popup). In this case,
     * use the background of the dialog.
     */
    public CheckableListAdapter(
            Context context, List<CheckableListAdapter.CheckableItem> items, boolean isDialog) {
        super(context, RESOURCE_ITEM_NAME, items);
        this.mIsDialog = isDialog;
    }

