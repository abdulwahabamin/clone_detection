    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Log.e("SELECT","on create options called");
        if (!mNavigationDrawerFragment.isDrawerOpen()) {

            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

