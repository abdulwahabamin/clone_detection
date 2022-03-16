    public final void disconnect( boolean brutal ) {
        //if( outputStream != null )  // ??? why? 
        {
            try {
                if( !brutal && loggedIn )
                    logout( true );
                if( outputStream != null ) outputStream.close();
                if(  inputStream != null )  inputStream.close();
                if(   cmndSocket != null )   cmndSocket.close();
                if( serverSocket != null ) serverSocket.close();
                if(   dataSocket != null )   dataSocket.close();
                if( inDataStream != null ) inDataStream.close();
            }
            catch( Exception e ) {
            	e.printStackTrace();
            }
            outputStream = null;
             inputStream = null;
              cmndSocket = null;
            serverSocket = null;
              dataSocket = null;
            inDataStream = null;
        }
    }

