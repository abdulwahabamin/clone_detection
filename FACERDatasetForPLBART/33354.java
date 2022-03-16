    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (adapter == null) {
            initialiseRecyclerViewAdapter();
        }
        recyclerView.setAdapter(adapter);
    }

