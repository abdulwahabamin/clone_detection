    public static MainThreadAction getInstance(){
        if (sIntance == null) {
            synchronized (LOCK) {
                if (sIntance == null) {
                    sIntance = new MainThreadAction();
                }
            }
        }

        return sIntance;
    }

