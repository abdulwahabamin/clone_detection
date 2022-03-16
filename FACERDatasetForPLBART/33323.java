    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onUtilityButtonClickedListener = (OnUtilityButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnUtilityButtonClickedListener");
        }
    }

