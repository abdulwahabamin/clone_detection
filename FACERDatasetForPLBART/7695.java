    protected void procInput( BufferedReader br ) 
              throws IOException, Exception { 
        if( br != null && result != null )
            while( br.ready() ) {
                Thread.sleep( 10 );
                if( isStopReq() ) 
                    throw new Exception();
                String ln = br.readLine();
                if( ln == null ) break;
                result.append( ln ).append( "\n" );
            }
    }

