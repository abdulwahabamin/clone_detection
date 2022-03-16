    /**
     * make the construction method private
     */

    private WeatherDB(Context context){
        WeatherDBOpenHelper dbHelper=new WeatherDBOpenHelper(context,DB_NAME,null,VERSION);
        db=dbHelper.getWritableDatabase();
    }

