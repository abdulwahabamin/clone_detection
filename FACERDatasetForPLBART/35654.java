    public static DownLoadManager getManager(){
        if (manager == null) {
            synchronized (DownLoadManager.class) {
                if (manager == null) {
                    manager = new DownLoadManager();
                }
            }
        }
        return manager;
    }

