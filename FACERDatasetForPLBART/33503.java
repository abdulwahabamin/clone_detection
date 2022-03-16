    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parentActivity = getActivity();
        try {
            onDialogButtonClickedListener = (OnDialogButtonClickedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnDialogButtonClickedListener");
        }
    }

