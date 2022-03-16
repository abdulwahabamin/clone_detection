    /**
     * Completely custom scroll speed profile. Default increases linearly
     * with position and is constant in time. Create your own by implementing
     * {@link DragSortListView.DragScrollProfile}.
     * 
     * @param scrollProfile
     */
    public void setDragScrollProfile(DragScrollProfile scrollProfile) {
        if (scrollProfile != null) {
            mScrollProfile = scrollProfile;
        }
    }

