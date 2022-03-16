    private List<MyCity> getMyCities(){
        List<MyCity> myCities = new ArrayList<>() ;
        WeatherDatabaseHelper databaseHelper = MyApplication.getInstance().getWeatherDatabaseHelper();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor c = db.query(WeatherDatabaseHelper.TABLE_CHINA_MY_CITY, new String[]{WeatherDatabaseHelper.CityColumns.CITY_ID,WeatherDatabaseHelper.MyCityColumns.INDEX}, null, null, null, null, null);
        if(c != null){
            try{
                while(c.moveToNext()){
                    myCities.add(new MyCity(c.getString(0), c.getString(1)));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                c.close();
            }
        }else{
        }
        Collections.sort(myCities, new Comparator<MyCity>() {
            @Override
            public int compare(MyCity lhs, MyCity rhs) {
                return Integer.parseInt(lhs.index) - Integer.parseInt(rhs.index);
            }
        });
        return myCities;
    }

