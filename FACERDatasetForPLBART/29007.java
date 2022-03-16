    public static JSONConverter getInstance() {
        if(instance == null) {
            instance = new JSONConverter();
        }
        return instance;
    }

