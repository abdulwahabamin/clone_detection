    protected final void sendReceiveReq( int recipient_hash, File dest_folder ) {
        File[] temp_content = dest_folder.listFiles();
        String[] paths = new String[temp_content.length];
        for( int i = 0; i < temp_content.length; i++ )
            paths[i] = temp_content[i].getAbsolutePath();
        sendReceiveReq( recipient_hash, paths );
    }    

