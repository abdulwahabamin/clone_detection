    /**
     * Method that returns the identifier of the second reference of the row data.
     *
     * @param position The row position
     * @return The second reference identifier at the specified position. If not
     * exists the returned identifier is <code>-1</code>
     */
    public long getItemId2(int position) {
        if ((position * 2) + 1 >= getMenu().size()) {
            return -1;
        }
        return getMenu().getItem((position * 2) + 1).getItemId();
    }

