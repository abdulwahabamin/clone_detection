    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //BLog.e("onOptionsItemSelected called: "+item.getItemId());
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id) {
            case R.id.action_search:
                Bgo.clearBackStack(activity);
                Bgo.openFragmentBackStack(activity,new SearchFragment());
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

