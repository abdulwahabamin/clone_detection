    public static NetService getInstance() {
        if (netService == null) {
            synchronized (NetService.class) {
                if (netService == null) {
                    netService = new NetService();
                }
            }
        }
        return netService;
    }

