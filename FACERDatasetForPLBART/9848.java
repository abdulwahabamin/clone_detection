    /**
     * Method that check the user preferences
     *
     * @return boolean Indicates if the user preferences was set
     * @hide
     */
    boolean checkUserPreferences() {
        boolean ret = false;
        if (!this.mLoaded) {
            // Check that the view is loaded
            if ((ViewGroup)this.mGrid.getChildAt(0) == null) return false;

            if (this.mPreferred != null) {
                boolean found = false;
                int cc = this.mIntents.size();
                for (int i = 0; i < cc; i++) {
                    ResolveInfo info = this.mIntents.get(i);
                    if (info.activityInfo.name.equals(this.mPreferred.activityInfo.name)) {
                        // Select the item
                        ViewGroup item = (ViewGroup)this.mGrid.getChildAt(i);
                        if (item != null) {
                            if (!mGrid.isItemChecked(i)) {
                                onItemClick(null, item, i, item.getId());
                                this.mRemember.setChecked(true);
                                ret = false;
                            } else {
                                this.mLoaded = true;
                                ret = true;
                            }
                        }
                        found = true;
                        break;
                    }
                }

                // Is there is no user preferences?
                if (!found) {
                    this.mLoaded = true;
                    ret = true;
                }
            } else {
                // There is no user preferences
                this.mLoaded = true;
                ret = true;
            }
        }
        return ret;
    }

