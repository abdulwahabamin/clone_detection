    /**
     * Fill the object from the parcel information.
     *
     * @param in The parcel information to recreate the object
     */
    private void readFromParcel(Parcel in) {
        //- 0
        int navigationViewsCount = in.readInt();
        this.mNavigationViews = new NavigationViewInfoParcelable[navigationViewsCount];
        for (int i = 0; i < navigationViewsCount; i++) {
            this.mNavigationViews[i] =
                    in.readParcelable(NavigationInfoParcelable.class.getClassLoader());
        }
        //- 1
        int hasHistoryInfo = in.readInt();
        if (hasHistoryInfo != 0) {
            List<History> history = new ArrayList<History>(hasHistoryInfo);
            in.readList(history, NavigationInfoParcelable.class.getClassLoader());
            this.mHistoryInfo = new ArrayList<History>(history);
        }
    }

