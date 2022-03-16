    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Different actions depending on user preference

        // Get the adapter and the fso
        FileSystemObjectAdapter adapter = ((FileSystemObjectAdapter)parent.getAdapter());
        if (adapter == null || position < 0 || (position >= adapter.getCount())) {
            return false;
        }
        FileSystemObject fso = adapter.getItem(position);

        // Parent directory hasn't actions
        if (fso instanceof ParentDirectory) {
            return false;
        }

        // Pick mode doesn't implements the onlongclick
        if (this.mNavigationMode.compareTo(NAVIGATION_MODE.PICKABLE) == 0) {
            return false;
        }

        onRequestMenu(fso);
        return true; //Always consume the event
    }

