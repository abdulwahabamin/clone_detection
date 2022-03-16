    /***
     * Method that do something when the DrawerLayout opened.
     */
    private void onDrawerLayoutOpened(View drawerView){
        if (mSearchView != null && mSearchView.getVisibility() == View.VISIBLE) {
            closeSearch();
            hideSoftInput(drawerView);
        }
    }

