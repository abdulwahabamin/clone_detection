        public NavigationTask(boolean useCurrent, boolean addToHistory, boolean reload,
                SearchInfoParcelable searchInfo, FileSystemObject scrollTo,
                Map<DisplayRestrictions, Object> restrictions, boolean chRooted) {
            super();
            this.mUseCurrent = useCurrent;
            this.mAddToHistory = addToHistory;
            this.mSearchInfo = searchInfo;
            this.mReload = reload;
            this.mScrollTo = scrollTo;
            this.mRestrictions = restrictions;
            this.mChRooted = chRooted;
        }

