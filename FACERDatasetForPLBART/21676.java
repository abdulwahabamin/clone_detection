    /**
     * @return the extra object data that was passed in to be attached to the current row
     */
    public Object getExtraData() {
        int position = getPosition();
        return position < mExtraData.size() ? mExtraData.get(position) : null;
    }

