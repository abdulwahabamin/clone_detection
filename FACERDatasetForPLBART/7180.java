        SearchEngine( Handler h, String match_, String path_, String pass_back_on_done_ ) {
            super( h );
            if( match_.indexOf( '*' ) >= 0 ){
                cards = Utils.prepareWildcard( match_ );
                match = null;
            }
            else {
                cards = null;
                match = match_.toLowerCase();
            }
            path = path_;
            pass_back_on_done = pass_back_on_done_;
            larger_than = 0; 
           smaller_than = Long.MAX_VALUE; 
        }

