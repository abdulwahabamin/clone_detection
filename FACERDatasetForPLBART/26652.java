    /**
     *
     * @param Time unix timestamp
     * @return SimpleDateFormat
     */
    public String convertTime(Integer Time){
        formattedDater = DateUtils.getRelativeTimeSpanString(Time, System.currentTimeMillis(), 0).toString();
        return formattedDater;
    }

