	@Override
	public void reqItemsSize( SparseBooleanArray cis ) {
	    if( uri == null ) return;
        try {
            LsItem[] s_items = bitsToItems( cis );
            if( s_items != null && s_items.length > 0 ) {
                String path = Utils.mbAddSl( uri.getPath() );
                StringBuilder sb = new StringBuilder( 128 );
                sb.append( "stat " );
                for( int i = 0; i < s_items.length; i++ )
                    sb.append( " " ).append( ExecEngine.prepFileName( path + s_items[i].getName() ) );
                sb.append( " ; df" );
                ExecEngine ee = new ExecEngine( ctx, new Handler() {
                        @Override
                        public void handleMessage( Message msg ) {
                            try {
                                Intent in = new Intent( ctx, TextViewer.class );
                                in.setData( Uri.parse( TextViewer.STRURI ) );
                                in.putExtra( TextViewer.STRKEY, (String)msg.obj );
                                commander.issue( in, 0 );
                            } catch( Exception e ) {
                                Log.e( TAG, null, e );
                            }
                        }
                    }, null, sb.toString(), true,  500 ); 
                ee.start();
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
	}

