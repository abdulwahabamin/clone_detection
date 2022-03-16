    @Override
    public CharSequence getPageTitle(int position) {
//        GregorianCalendar calendar = new GregorianCalendar();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        dateFormat.setCalendar(calendar);
//        calendar.setTimeInMillis(lastUpdateTime*1000);
        if(cities.size() == 0) {
            return mContext.getString(R.string.app_name);
        }
        return cities.get(position).getCityName(); // + " (" + dateFormat.format(calendar.getTime()) + ")";
    }

