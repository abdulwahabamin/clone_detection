    @Override
    protected void onReadComplete() {
        if( reader instanceof ListEngine ) {
            ListEngine list_engine = (ListEngine)reader;
            pkgInfos = list_engine.getItems();
            reSort();
            numItems = pkgInfos != null ? pkgInfos.length+1 : 1;
            notifyDataSetChanged();
        }
    }

