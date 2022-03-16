    @Override
    public void showListView(List<FutureContext> list) {
        adapter = new FutureListAdapter(list);
        Logger.d(list.get(0).getCond());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

