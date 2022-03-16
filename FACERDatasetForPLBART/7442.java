    public final Credentials borrowPassword( Uri stranger_uri ) {
        if( credentials == null ) return null;
        String stranger_user_info = stranger_uri.getUserInfo();
        String username = credentials.getUserName(); 
        String password = credentials.getPassword(); 
        if( username != null && password != null && stranger_user_info != null && stranger_user_info.length() > 0 ) {
            Credentials stranger_crd = new Credentials( stranger_user_info );
            String stranger_username = stranger_crd.getUserName();
            if( username.equalsIgnoreCase( stranger_username ) )
                return new Credentials( stranger_username, password );
        }
        return null;
    }

