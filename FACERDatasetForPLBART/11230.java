    /**
     * Constructor of <code>MenuSettingsAdapter</code>.
     *
     * @param context The current context
     * @param setting The setting to add to the current list
     */
    public MenuSettingsAdapter(Context context, FileManagerSettings setting) {
        this(context, Arrays.asList(new FileManagerSettings[]{setting}));
        addSetting(context, setting);
    }

