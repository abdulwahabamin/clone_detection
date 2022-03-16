    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //Log.e("TOOLBAR", "onOptionsItemSelected called");

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if(mDrawerLayout!=null)
            mDrawerLayout.bringToFront();
        return super.onOptionsItemSelected(item);
    }

