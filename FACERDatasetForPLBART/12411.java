    /**
     * Method that sets the value of an slot.
     *
     * @param query The text of the query at the slot
     * @param slot The slot number
     * @return Query The query reference
     */
    public Query setSlot(String query, int slot) {
        this.mQUERIES[slot] = query;
        return this;
    }

