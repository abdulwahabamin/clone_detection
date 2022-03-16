    public static BLEPeripheralHelper getInstance() {
        if (instance == null) {
            synchronized (BLEPeripheralHelper.class) {
                if (instance == null) {
                    instance = new BLEPeripheralHelper();
                }
            }
        }
        return instance;
    }

