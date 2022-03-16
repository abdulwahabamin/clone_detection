    public final static boolean isPwdScreened( Uri u ) {
        String user_info = u.getUserInfo();
        if( user_info != null && user_info.length() > 0 ) {
            UsernamePasswordCredentials crd = new UsernamePasswordCredentials( user_info );
            if( Credentials.pwScreen.equals( crd.getPassword() ) ) return true;
        }
        return false;
    }

