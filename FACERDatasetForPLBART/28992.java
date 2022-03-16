    public void createTable1(SQLiteDatabase db) {
        db.execSQL("create table my_table ("
                + "_id integer primary key autoincrement,"
                + "city_id integer,"
                + "city_country_name text" + ");");
    }

