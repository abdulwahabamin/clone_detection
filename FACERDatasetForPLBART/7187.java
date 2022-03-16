    protected void onReadComplete() {  
        try {
            if( reader instanceof SearchEngine ) {
                SearchEngine list_engine = (SearchEngine)reader;
                items = list_engine.getItems( mode );
                numItems = items != null ? items.length + 1 : 1;
                notifyDataSetChanged();
                startThumbnailCreation();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

