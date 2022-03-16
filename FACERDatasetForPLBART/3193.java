    private void init() {
        fileArrayAdapter = new FileArrayAdapter(mainViewFragment.getActivity(),
                R.layout.list_row, listFiles);
        mainViewFragment.setListAdapter(fileArrayAdapter);
        mainViewFragment.getActivity().getLoaderManager().initLoader(0, null, this);
        fileLoader.forceLoad();
    }

