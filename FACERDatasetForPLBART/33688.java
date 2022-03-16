    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parentActivity = activity;
        listener = (OnJsonStringRetrievedListener) activity;
    }

