    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setControllerFragment(new ControllerFragment(this));
        registerForContextMenu(getListView());
        activityContext = (MainActivity) getActivity();
    }

