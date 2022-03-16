    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean intercept=false;
        switch(item.getItemId()) {
            case R.id.action_search:
                //State.sectionsClearBackstack();

                Bgo.openFragmentBackStack(activity,new SearchFragment());
                intercept=true;
                break;


        }
        return intercept;
    }

