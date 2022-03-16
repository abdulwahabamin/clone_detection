    @Override
    public boolean renameItem( int p, String newName, boolean c  ) {
        if( favs != null && p > 0 && p <= favs.size() ) {
            favs.get( p-1 ).setComment( newName );
            notifyDataSetChanged();
            return true;
        }
        return false;
    }

