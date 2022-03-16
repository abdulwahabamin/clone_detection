    /**
     * Method that returns the {@link MenuItem} reference from
     * his identifier.
     *
     * @param id The identifier of the item menu
     * @return MenuItem The reference. <code>null</code> if not found.
     */
    public MenuItem getItemById(int id) {
        return getMenu().findItem(id);
    }

