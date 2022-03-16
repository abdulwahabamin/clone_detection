    public boolean reqStop() {
        if( isAlive() ) {
            Log.i( getClass().getName(), "reqStop()" );
            if( stop )
                interrupt();
            else
                stop = true;
            return true;
        }
        else {
            Log.i( getClass().getName(), "Engine thread is not alive" );
            return false;
        }
    }

