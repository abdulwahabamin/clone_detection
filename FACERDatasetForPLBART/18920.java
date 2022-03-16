    @SuppressLint("NewApi")
    @Override
    public void onResume() {
        super.onResume();

        //Apply the ActionBar title.
        getActivity().getActionBar().setTitle(mFragmentTitle);

    }

