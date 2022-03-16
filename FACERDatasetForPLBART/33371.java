    /**
     * An adapter to map the cities stored in the database to the city list rows
     * with buttons requesting various weather information.
     */
    CityWeatherCursorAdapter(Context context, int layout, Cursor c,
                             String[] from, int[] to, int flags, OnClickListener onClickListener) {
        super(context, layout, c, from, to, flags, onClickListener);
    }

