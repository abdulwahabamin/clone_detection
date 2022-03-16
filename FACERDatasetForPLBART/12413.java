    /**
     * Method that fill all the available slots (filled from the minimum
     * to the maximum slot).
     *
     * @param queries The queries which fill the slots
     * @return Query The query reference
     */
    public Query fillSlots(List<String> queries) {
        int cc = queries.size();
        for (int i = 0; i < cc; i++) {
            if (i > this.mQUERIES.length) {
                break;
            }
            this.mQUERIES[i] = queries.get(i);
        }
        return this;
    }

