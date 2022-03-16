    /**
     * Method that returns the list of queries.
     *
     * @return List<String> The list of queries
     */
    public List<String> getQueries() {
        List<String> queries = new ArrayList<String>(getSlotsCount());
        int cc = this.mQUERIES.length;
        for (int i = 0; i < cc; i++) {
            if (this.mQUERIES[i] != null && this.mQUERIES[i].length() > 0) {
                queries.add(this.mQUERIES[i]);
            }
        }
        return queries;
    }

