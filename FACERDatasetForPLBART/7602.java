    public final void copyName() {
        try {
            CommanderAdapter ca = getListAdapter( true );
            if( ca == null ) return;
            ClipboardManager clipboard = (ClipboardManager)c.getSystemService( Context.CLIPBOARD_SERVICE );
            int pos = getSelection( true );
            if( pos >= 0 ) {
                String in = ca.getItemName( pos, true );
                if( in != null ) {
                    if( in.startsWith( RootAdapter.DEFAULT_LOC ) )
                        in = Uri.parse( in ).getPath();
                    clipboard.setText( in );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

