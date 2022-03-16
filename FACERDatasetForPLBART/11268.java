    /**
     * Method that returns the second reference of the row data.
     *
     * @param position The row position
     * @return The second reference data (if exists) at the specified position.
     */
    public MenuItem getItem2(int position) {
        if ((position * 2) + 1 >= getMenu().size()) {
            return null;
        }
        return getMenu().getItem((position * 2) + 1);
    }

