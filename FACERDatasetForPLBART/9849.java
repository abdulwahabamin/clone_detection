    /**
     * Method that returns if the preferred intent is still selected
     *
     * @return  if the preferred intent is selected
     */
    private boolean isPreferredSelected() {
        if (this.mPreferred != null) {
            int cc = this.mIntents.size();
            for (int i = 0; i < cc; i++) {
                ResolveInfo info = this.mIntents.get(i);
                if (info.activityInfo.name.equals(this.mPreferred.activityInfo.name)) {
                    ViewGroup item = (ViewGroup)this.mGrid.getChildAt(i);
                    if (item != null && mGrid.isItemChecked(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

