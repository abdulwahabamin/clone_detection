    @MainThread
    public static <T extends RoomDatabase >  T provider(Class<T> dbCls , String dbName) {
         /*
        使用fallbackToDestructiveMigration暴力�?�级数�?�库，
        更多�?�级方�? see{@link # http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2017/0728/8278.html}
         */
        return Room.databaseBuilder(CoreManager.getContext(),
                dbCls, dbName).fallbackToDestructiveMigration().build();
    }

