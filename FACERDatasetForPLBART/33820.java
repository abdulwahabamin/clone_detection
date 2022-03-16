    /**
     * Stop a drag in progress. Pass <code>true</code> if you would
     * like to remove the dragged item from the list.
     *
     * @param remove Remove the dragged item from the list. Calls
     * a registered RemoveListener, if one exists. Otherwise, calls
     * the DropListener, if one exists.
     *
     * @return True if the stop was successful. False if there is
     * no floating View.
     */
    public boolean stopDrag(boolean remove) {
        mUseRemoveVelocity = false;
        return stopDrag(remove, 0);
    }

