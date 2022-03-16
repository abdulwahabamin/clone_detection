    public State getState() {
        Log.v( TAG, "getState()");
        State s = new State();
        s.current = current;
        try {
            CommanderAdapter  left_adapter = (CommanderAdapter)list[LEFT].getListAdapter();
            s.leftUri = left_adapter.getUri();
            s.leftCrd = left_adapter.getCredentials();
            int pos = list[LEFT].getCurPos();
            s.leftItem = pos >= 0 ? left_adapter.getItemName( pos, false ) : "";

            CommanderAdapter right_adapter = (CommanderAdapter)list[RIGHT].getListAdapter();
            s.rightUri = right_adapter.getUri();
            s.rightCrd = right_adapter.getCredentials();
            pos = list[RIGHT].getCurPos();
            s.rightItem = pos >= 0 ? right_adapter.getItemName( pos, false ) : "";
            
            s.favs = favorites.getAsString();
        } catch( Exception e ) {
            Log.e( TAG, "getState()", e );
        }
        return s;
    }

