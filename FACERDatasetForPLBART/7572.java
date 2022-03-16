    public final File getCurrentFile() {
        try {
            CommanderAdapter ca = getListAdapter( true );
            if( ( ca.getType() & ( CA.LOCAL | CA.APPS ) ) != 0 ) {
                int pos = getSelection( true );
                if( pos < 0 ) return null;
                CommanderAdapter.Item item = (CommanderAdapter.Item)((ListAdapter)ca).getItem( pos ); 
                if( item != null && item.origin != null )
                    return (File)item.origin; 
            }
        }
        catch( Exception e ) {
            Log.e( TAG, "getCurrentFile()", e );
        }
        return null;
    }

