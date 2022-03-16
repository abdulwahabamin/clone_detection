    public final void setPanelTitle( String s, int which ) {
        try {
            TextView title = (TextView)c.findViewById( titlesIds[which] );
            if( title != null ) {
            	int p_width = mainView.getWidth();
            	if( p_width > 0 )
            		title.setMaxWidth( p_width / 2 );
                if( s == null ) {
                    title.setText( c.getString( R.string.fail ) );
                }
                else {
                    UrlQuerySanitizer urlqs = new UrlQuerySanitizer();
                    title.setText( urlqs.unescape( Favorite.screenPwd( s ) ) );
                }
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }

