    @MainThread
    public static <T extends RoomDatabase >  T provider(Class<T> dbCls , String dbName) {
         /*
        ä½¿ç”¨fallbackToDestructiveMigrationæš´åŠ›å?‡çº§æ•°æ?®åº“ï¼Œ
        æ›´å¤šå?‡çº§æ–¹å¼? see{@link # http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0728/8278.html}
         */
        return Room.databaseBuilder(CoreManager.getContext(),
                dbCls, dbName).fallbackToDestructiveMigration().build();
    }

