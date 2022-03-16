    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.playlist_item_row, listItems);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(this);
    }

