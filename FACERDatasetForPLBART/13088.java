    /**
     * Method that change the view mode.
     *
     * @param newMode The new mode
     */
    @SuppressWarnings("unchecked")
    public void changeViewMode(final NavigationLayoutMode newMode) {
        //Check that it is really necessary change the mode
        if (this.mCurrentMode != null && this.mCurrentMode.compareTo(newMode) == 0) {
            return;
        }

        // If we should set the listview to response to flinger gesture detection
        boolean useFlinger =
                Preferences.getSharedPreferences().getBoolean(
                        FileManagerSettings.SETTINGS_USE_FLINGER.getId(),
                        ((Boolean)FileManagerSettings.
                                SETTINGS_USE_FLINGER.
                                getDefaultValue()).booleanValue());

        //Creates the new layout
        AdapterView<ListAdapter> newView = null;
        int itemResourceId = -1;
        if (newMode.compareTo(NavigationLayoutMode.ICONS) == 0) {
            newView = (AdapterView<ListAdapter>)inflate(
                    getContext(), RESOURCE_MODE_ICONS_LAYOUT, null);
            itemResourceId = RESOURCE_MODE_ICONS_ITEM;

        } else if (newMode.compareTo(NavigationLayoutMode.SIMPLE) == 0) {
            newView =  (AdapterView<ListAdapter>)inflate(
                    getContext(), RESOURCE_MODE_SIMPLE_LAYOUT, null);
            itemResourceId = RESOURCE_MODE_SIMPLE_ITEM;

            // Set the flinger listener (only when navigate)
            if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
                if (useFlinger && newView instanceof FlingerListView) {
                    ((FlingerListView)newView).
                    setOnItemFlingerListener(this.mOnItemFlingerListener);
                }
            }

        } else if (newMode.compareTo(NavigationLayoutMode.DETAILS) == 0) {
            newView =  (AdapterView<ListAdapter>)inflate(
                    getContext(), RESOURCE_MODE_DETAILS_LAYOUT, null);
            itemResourceId = RESOURCE_MODE_DETAILS_ITEM;

            // Set the flinger listener (only when navigate)
            if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
                if (useFlinger && newView instanceof FlingerListView) {
                    ((FlingerListView)newView).
                    setOnItemFlingerListener(this.mOnItemFlingerListener);
                }
            }
        }

        //Get the current adapter and its adapter list
        List<FileSystemObject> files = new ArrayList<FileSystemObject>(this.mFiles);
        final AdapterView<ListAdapter> current =
                (AdapterView<ListAdapter>)findViewById(RESOURCE_CURRENT_LAYOUT);
        FileSystemObjectAdapter adapter =
                new FileSystemObjectAdapter(
                        getContext(),
                        new ArrayList<FileSystemObject>(),
                        itemResourceId,
                        this.mNavigationMode.compareTo(NAVIGATION_MODE.PICKABLE) == 0);
        adapter.setOnSelectionChangedListener(this);

        //Remove current layout
        if (current != null) {
            if (current.getAdapter() != null) {
                //Save selected items before dispose adapter
                FileSystemObjectAdapter currentAdapter =
                        ((FileSystemObjectAdapter)current.getAdapter());
                adapter.setSelectedItems(currentAdapter.getSelectedItems());
                currentAdapter.dispose();
            }
            removeView(current);
        }
        this.mFiles = files;
        adapter.addAll(files);

        //Set the adapter
        this.mAdapter = adapter;
        newView.setAdapter(this.mAdapter);
        newView.setOnItemClickListener(NavigationView.this);

        //Add the new layout
        this.mAdapterView = newView;
        addView(newView, 0);
        this.mCurrentMode = newMode;

        // Pick mode doesn't implements the onlongclick
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
            this.mAdapterView.setOnItemLongClickListener(this);
        } else {
            this.mAdapterView.setOnItemLongClickListener(null);
        }

        //Save the preference (only in navigation browse mode)
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.BROWSABLE) == 0) {
            try {
                Preferences.savePreference(
                        FileManagerSettings.SETTINGS_LAYOUT_MODE, newMode, true);
            } catch (Exception ex) {
                Log.e(TAG, "Save of view mode preference fails", ex); //$NON-NLS-1$
            }
        }
    }

