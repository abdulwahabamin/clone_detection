    public void createEntries() {
        ArrayList<WeatherFort.WeatherList> list;
        try {
            list = mDescribable;
            for (int i = 0; i < 10; ++i) {
                long day = list.get(i).getDt();
                long temp = list.get(i).getTemp().getDay();
                long pressure = (long) list.get(i).getPressure();
                long rain;
                try {
                    rain = (long) list.get(i).getRain();
                }
                catch (Exception ex) {
                    rain = 0;
                }
                long snow;
                try {
                    snow = (long) list.get(i).getSnow();
                }
                catch (Exception ex) {
                    snow = 0;
                }
                long wind = (long) list.get(i).getSpeed();
                tempEntries.add(new Entry(i , temp));
                rainEntries.add(new Entry(i , rain));
                pressureEntries.add(new Entry(i , pressure));
                snowEntries.add(new Entry(i , snow));
                windEntries.add(new Entry(i , wind));
                Log.i("Added" , "Entry : " + i + " " + temp);
                dates[i] = getDay(day);
                Log.i("Added" , "Day : " + dates[i]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Caught" , "JSON Ex");
        }
    }

