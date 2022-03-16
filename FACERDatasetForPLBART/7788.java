    public void executeToViewer( String command, boolean bb ) {
        ExecEngine ee = new ExecEngine( ctx, new Handler() {
                @Override
                public void handleMessage( Message msg ) {
                    try {
                        String str = (String)msg.obj;
                        if( !Utils.str( str ) ) {
                            msg.obj = ctx.getString( R.string.nothing ); 
                            commander.notifyMe( msg );
                        }
                        else {
                            Intent in = new Intent( ctx, TextViewer.class );
                            in.setData( Uri.parse( TextViewer.STRURI ) );
                            in.putExtra( TextViewer.STRKEY, str );
                            commander.issue( in, 0 );
                        }
                    } catch( Exception e ) {
                        e.printStackTrace();
                    }
                }
            }, uri.getPath(), command, bb, 500 ); 
        ee.start();
    }    

