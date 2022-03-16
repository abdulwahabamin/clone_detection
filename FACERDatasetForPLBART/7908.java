    private final int parsePassiveResponse( String s, byte[] addr ) {
        try {
        	if( s == null || s.length() < 4 )
        		return -1;
            if( !isPositiveComplete( Integer.parseInt( s.substring( 0, 3 ) ) ) )
                return -1;
            // responses could be:
            // 227 Entering Passive Mode (10,0,0,4,134,65)
            // 227 Entering Passive Mode. 10,0,0,4,134,65
            int opt = s.indexOf( '(' );
            int cpt = s.indexOf( ')' );
            if( cpt < opt )
                return -1;
            StringTokenizer addr_tokenizer;
            if( opt == -1 && cpt == -1 ) { // no parentheses 
            	String addr_str = s.replaceFirst( "\\d{3}\\s[^\\d]+", "" );
            	addr_tokenizer = new StringTokenizer( addr_str, "," );
            }
            else
            	addr_tokenizer = new StringTokenizer( s.substring( opt + 1, cpt ), "," );
            int a = 0, b = 0;
            for( int i = 0; i < 6; i++ ) {
                short n = Short.parseShort( addr_tokenizer.nextToken() );
                if( i < 4 )
                    addr[i] = (byte)n;
                else {
                    if( i == 4 )
                        a = n;
                    if( i == 5 )
                        b = n;
                }
                if( !addr_tokenizer.hasMoreTokens() )
                    break;
            }
            return a * 256 + b;
        }
        catch( RuntimeException  e ) {
            Log.e( TAG, "Exception while parsing the string '" + s + "'", e );
        }
        return -1;
    }

