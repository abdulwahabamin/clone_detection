    /**
     * @return the list of ids that were in the underlying cursor but not part of the ordered list
     */
    public Collection<Long> getExtraIds() {
        return mMapCursorPositions.keySet();
    }

