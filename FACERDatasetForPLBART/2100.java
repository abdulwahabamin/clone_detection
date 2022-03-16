    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            dirSelectedListener = (OnDirectorySelectedListener) getParentFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " " +
                    R.string.exception_OnFragmentInteractionListener);
        }
    }

