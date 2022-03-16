    /**
     * Method that creates a data holder.
     *
     * @param id The identifier of the setting
     * @param title The title
     * @param setting The setting
     * @param selected If the setting is selected
     * @return DataHolder The holder with the data
     */
    @SuppressWarnings("static-method")
    private DataHolder createDataHolder(
            int id, FileManagerSettings setting, String title, boolean selected) {
        DataHolder dataHolder = new DataHolder();
        dataHolder.mId = id;
        dataHolder.mSetting = setting;
        dataHolder.mItem = new CheckableItem(title, true, selected);
        return dataHolder;
    }

