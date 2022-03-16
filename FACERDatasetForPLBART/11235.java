    /**
     * Method that adds a new setting to the collection of items.<br />
     *
     * @param context The current context
     * @param setting The setting to add to the current list
     */
    private void addSetting(Context context, FileManagerSettings setting) {
        //Only 2 type of settings are allowed
        final Resources res = context.getResources();
        try {
            // Enum<ObjectIdentifier>
            if (setting.getDefaultValue() instanceof Enum<?>
                && setting.getDefaultValue() instanceof ObjectIdentifier) {
                //Retrieve all the items of the enumeration
                int resid =
                        ResourcesHelper.getIdentifier(res, "array", setting.getId()); //$NON-NLS-1$
                String[] titles = res.getStringArray(resid);
                Method method =
                        setting.getDefaultValue().getClass().getMethod("values"); //$NON-NLS-1$
                ObjectIdentifier[] ids = (ObjectIdentifier[])method.invoke(null);
                int defaultid = ((ObjectIdentifier)setting.getDefaultValue()).getId();
                int selected =
                        Preferences.getSharedPreferences().getInt(setting.getId(), defaultid);
                int cc = ids.length;
                for (int i = 0; i < cc; i++) {
                    //Create the data holder
                    DataHolder dataHolder =
                            createDataHolder(
                                    ids[i].getId(),
                                    setting,
                                    titles[i],
                                    ids[i].getId() == selected);
                    this.mData.add(dataHolder);

                    //Add to the list
                    add(dataHolder.mItem);
                }
                return;
            }

            // Enum<ObjectStringIdentifier>
            if (setting.getDefaultValue() instanceof Enum<?>
                && setting.getDefaultValue() instanceof ObjectStringIdentifier) {
                //Retrieve all the items of the enumeration
                int resid =
                        ResourcesHelper.getIdentifier(res, "array", setting.getId()); //$NON-NLS-1$
                String[] titles = res.getStringArray(resid);
                Method method =
                        setting.getDefaultValue().getClass().getMethod("values"); //$NON-NLS-1$
                ObjectStringIdentifier[] ids = (ObjectStringIdentifier[])method.invoke(null);
                String defaultid = ((ObjectStringIdentifier)setting.getDefaultValue()).getId();
                String selected =
                        Preferences.getSharedPreferences().getString(setting.getId(), defaultid);
                int cc = ids.length;
                for (int i = 0; i < cc; i++) {
                    //Create the data holder
                    DataHolder dataHolder =
                            createDataHolder(
                                    i,
                                    setting,
                                    titles[i],
                                    ids[i].getId() == selected);
                    this.mData.add(dataHolder);

                    //Add to the list
                    add(dataHolder.mItem);
                }
                return;
            }

            // Boolean
            if (setting.getDefaultValue() instanceof Boolean) {
                int resid =
                        ResourcesHelper.getIdentifier(
                                res, "string", setting.getId()); //$NON-NLS-1$
                String title = res.getString(resid);
                boolean selected =
                        Preferences.getSharedPreferences().
                            getBoolean(
                                setting.getId(),
                                ((Boolean)setting.getDefaultValue()).booleanValue());

                //Create the data holder
                DataHolder dataHolder = createDataHolder(-1, setting, title, selected);
                this.mData.add(dataHolder);

                //Add to the list
                add(dataHolder.mItem);
                return;
            }
        } catch (Exception e) {
            /**NON BLOCK**/
        }
        //Not allowed
        throw new IllegalArgumentException();
    }

