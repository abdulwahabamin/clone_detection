    public static BetterLoad getInstance(){
        if (betterLoad == null) {
            synchronized (BetterLoad.class) {
                if (betterLoad == null) {
                    betterLoad = new BetterLoad();
                }
            }
        }
        return betterLoad;
    }

