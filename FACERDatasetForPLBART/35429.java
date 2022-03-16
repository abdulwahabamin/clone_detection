    @Override
    public void showQueryData(List<CityContext> data) {
        adapter = new CityListAdapter(data,getActivity());
        listView.setAdapter(adapter);
        listView.setEmptyView(mTextView);
    }

