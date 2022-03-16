    @Override
    protected void procInput( BufferedReader br ) throws IOException, Exception {
        while( br.ready() ) {
            if( isStopReq() ) 
                throw new Exception();
            String ln = br.readLine();
            if( ln == null ) break;
            if( ln.length() == 0 ) continue;
            if( system && ln.indexOf( "/system " ) < 0 ) continue;
            MountItem item = new MountItem( ln );
            if( item.isValid() )
                array.add( item );
        }
   }

