    public SearchPacket(int type, int Rdrawable, String term) {
        super();
        setInt(INT_TYPE, type);
        setInt(INT_ICON,Rdrawable);
        setString(STRING_TERM,term);
    }

