    /**
     * Method that return AID from its user name.
     *
     * @param name The user identifier
     * @return AID The AID
     */
    public static AID getAIDFromName(String name) {
        int len = sAids.size();
        for (int i = 0; i < len; i++) {
            AID aid = sAids.valueAt(i);
            if (aid.getName().compareTo(name) == 0) {
                return aid;
            }
        }
        return new AID(-1, ""); //$NON-NLS-1$
    }

