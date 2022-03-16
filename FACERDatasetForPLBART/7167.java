        private int getWeight( Uri u ) {
            int w = 0;
            if( u != null ) {
                w++;
                String s = u.getScheme();
                if( s != null ) {
                    w++;
                    if( "ftp".equals( s ) ) w++; else
                    if( "smb".equals( s ) ) w+=2;
                }
            }
            return w;
        }

