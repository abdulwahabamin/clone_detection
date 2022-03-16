    public synchronized StringBuilder getResult() {
        try {
            wait( 500 );
        } catch( InterruptedException e ) {}
        return done ? result : null;
    }

