    @Override
    public void openItem( int position ) {
        if( position == 0 ) { // ..
            if( uri != null ) {
                commander.Navigate( Uri.parse( uri.getPath() ), null, null );
            }
            return;
        }
        super.openItem( position );
    }

