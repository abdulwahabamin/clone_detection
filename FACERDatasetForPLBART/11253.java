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
    public SimpleMenuListAdapter(Context context, int menuResourceId, int menuGroupResourceId,
                                 boolean multiSelect) {
        this(context, menuResourceId, multiSelect);

        //Remove all item menus that no belongs to the group
        int cc = this.mMenu.size();
        for (int i = cc - 1; i >= 0; i--) {
            MenuItem menuItem = this.mMenu.getItem(i);
            if (menuItem.getGroupId() != menuGroupResourceId) {
                this.mMenu.removeItem(menuItem.getItemId());
            }
        }
    }

