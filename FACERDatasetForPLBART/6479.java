        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + TABLE_RECENT + " (" +
                    RecentColumns.KEY + " TEXT PRIMARY KEY ON CONFLICT REPLACE," +
                    RecentColumns.STACK + " BLOB DEFAULT NULL," +
                    RecentColumns.TIMESTAMP + " INTEGER" +
                    ")");

            db.execSQL("CREATE TABLE " + TABLE_STATE + " (" +
                    StateColumns.AUTHORITY + " TEXT," +
                    StateColumns.ROOT_ID + " TEXT," +
                    StateColumns.DOCUMENT_ID + " TEXT," +
                    StateColumns.MODE + " INTEGER," +
                    StateColumns.SORT_ORDER + " INTEGER," +
                    "PRIMARY KEY (" + StateColumns.AUTHORITY + ", " + StateColumns.ROOT_ID + ", "
                    + StateColumns.DOCUMENT_ID + ")" +
                    ")");

            db.execSQL("CREATE TABLE " + TABLE_RESUME + " (" +
                    ResumeColumns.PACKAGE_NAME + " TEXT NOT NULL PRIMARY KEY," +
                    ResumeColumns.STACK + " BLOB DEFAULT NULL," +
                    ResumeColumns.TIMESTAMP + " INTEGER," +
                    ResumeColumns.EXTERNAL + " INTEGER NOT NULL DEFAULT 0" +
                    ")");
        }

