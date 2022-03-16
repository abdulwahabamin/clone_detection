    @Override
    public String toString() {
        if( uri == null )
            return "";
        String ui = uri.getUserInfo();
        if( ui != null && theUserPass == null )
            return Favorite.screenPwd( uri );
        if( theUserPass == null || theUserPass.isNotSet() )
            return uri.toString();
        return Favorite.screenPwd( Utils.getUriWithAuth( uri, theUserPass ) );    
    }

