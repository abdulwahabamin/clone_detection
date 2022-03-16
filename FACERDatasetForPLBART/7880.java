    public static Credentials createFromEncriptedString( String s ) {
        try {
            return new Credentials( decrypt( seed, s ) );
        } catch( Exception e ) {
            Log.e( TAG, "on creating from an encrypted string", e );
        }
        return null;
    }

