    public static Uri getUriWithAuth( Uri u, String un, String pw ) {
        if( un == null ) return u;
        String ui = Utils.escapeName( un );
        if( pw != null )
            ui += ":" + Utils.escapeName( pw );
        return updateUserInfo( u, ui );
    }

