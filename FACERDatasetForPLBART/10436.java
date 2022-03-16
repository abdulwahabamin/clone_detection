    /**
     * Method that returns the name in safe way
     *
     * @param id The id
     * @return String The name of the AID of null if not found
     */
    public static String getNullSafeName(int id) {
        AID aid = getAID(id);
        if (aid != null) {
            return aid.getName();
        }
        return null;
    }

