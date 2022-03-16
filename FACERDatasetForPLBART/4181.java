    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            Log.e("Callback","callback navigation - attached");
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

