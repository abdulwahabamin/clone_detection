        @Override
        public void onCreate(SQLiteDatabase db) {
            for(Table table : tables) {
                db.execSQL(table.createTableQuery());
            }

            for(Table table : remoteTables) {
                db.execSQL(table.createTableQuery());
            }
        }

