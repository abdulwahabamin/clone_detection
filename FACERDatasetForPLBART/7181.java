        final void setTypes( boolean files_only ) {
            if( files_only ) {
                files = true;
                dirs = false;
            } else {
                files = false;
                dirs = true;
            } 
        }

