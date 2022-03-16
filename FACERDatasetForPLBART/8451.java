    /**
     * Constructor of <code>MenuSettingsAdapter</code>.
     *
     * @param context The current context
     * @param settings An array of setting to add to the current list
     */
    public MenuSettingsAdapter(Context context, List<FileManagerSettings> settings) {
        super(context, new ArrayList<CheckableListAdapter.CheckableItem>());

        //Process the data
        this.mData = new ArrayList<MenuSettingsAdapter.DataHolder>();
        int cc = settings.size();
        for (int i = 0; i < cc; i++) {
            addSetting(context, settings.get(i));
        }
    }

