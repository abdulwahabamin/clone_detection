    @Override
    protected MetadataCategoryListAdapter createListAdapter() {
        return new MetadataCategoryListAdapter(
                getActivity(),
                R.layout.track_list_item,
                null,
                new String[] {},
                new int[] {},
                this);
    }

