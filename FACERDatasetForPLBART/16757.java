    @Override
    public void onDetach() {
        FireLog.d(TAG, "(++) onDetach");
        onCategorySelectedListener = null;
        super.onDetach();
    }

