    public void init( Uri u ) {
        try {
            uri = u;
            String user_info = uri.getUserInfo();
            if( user_info != null && user_info.length() > 0 ) {
                credentials = new Credentials( user_info );
                String pw = credentials.getPassword();
                if( Credentials.pwScreen.equals( pw ) ) 
                    credentials = new Credentials( credentials.getUserName(), credentials.getPassword() );
                uri = Utils.updateUserInfo( uri, null );
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }    

