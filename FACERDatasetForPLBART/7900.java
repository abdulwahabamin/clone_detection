    private final int getReplyCode( String reply ) {
        try {
            return reply == null ? -1 : Integer.parseInt( reply.substring( 0, 3 ) );
        }
        catch( NumberFormatException e ) {
            return -1;
        }
    }

