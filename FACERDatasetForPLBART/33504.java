    @Override
    public void onDetach() {
        super.onDetach();
        parentActivity = null;
        onDialogButtonClickedListener = null;
    }

