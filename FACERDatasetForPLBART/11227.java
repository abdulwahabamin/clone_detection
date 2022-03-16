    /**
     * Constructor of <code>SimpleMenuListAdapter</code><br/>
     * <br/>.
     * This constructors uses only the menus of the group passed
     *
     * @param context The current context
     * @param menuResourceId The resource identifier
     * @param menuGroupResourceId The menu group resource identifier
     * @param multiSelect Whether the menu allows for single or multi select
     */
    public HighlightedSimpleMenuListAdapter(
            Context context, int menuResourceId, int menuGroupResourceId, boolean multiSelect) {
        this(context, menuResourceId, multiSelect);
    }

