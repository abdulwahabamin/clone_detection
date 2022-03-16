    private void reloadLastItems() {
        List<IndexerFile> items = IndexerDb.getDb().getImageVideoItems(0, 10);
        GridView lastfiles = (GridView) getActivity().findViewById(R.id.nav_shortcuts);

        lastfiles.setAdapter(new LastFilesAdapter(getActivity(),lastfiles,items));
        lastfiles.refreshDrawableState();
    }

