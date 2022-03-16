    public static <T> T checkNotNull(T ref) {
        if (ref == null) {
            throw new NullPointerException();
        }else{
            return ref;
        }
    }

