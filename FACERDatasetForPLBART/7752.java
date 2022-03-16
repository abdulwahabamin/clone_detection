        @Override
        protected void procInput( BufferedReader br ) throws IOException, Exception {
            while( br.ready() ) {
                if( isStopReq() ) break; 
                String ln = br.readLine();
                if( ln == null || ln.startsWith( EOL ) ) break;
                LsItem item = new LsItem( ln );
                if( item.isValid() ) {
                    if( !"..".equals( item.getName() ) && !".".equals( item.getName() ) )
                        array.add( item ); // a problem - if the item is a symlink - how to know it's a dir or a file???
                }
            }
       }

