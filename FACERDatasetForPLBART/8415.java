    /**
     * Method that process the data before use {@link #getView} method.
     *
     * @param intents The list of intents (to better performance) or null.
     */
    private void processData(List<ResolveInfo> intents) {
        this.mData = new DataHolder[getCount()];
        int cc = (intents == null) ? getCount() : intents.size();
        for (int i = 0; i < cc; i++) {
            //Intent info
            ResolveInfo intentInfo = (intents == null) ? getItem(i) : intents.get(i);

            //Build the data holder
            this.mData[i] = new AssociationsAdapter.DataHolder();
            this.mData[i].mDwIcon = intentInfo.loadIcon(getContext().getPackageManager());
            this.mData[i].mName =
                    intentInfo.loadLabel(getContext().getPackageManager()).toString();
        }
    }

