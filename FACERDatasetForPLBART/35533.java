    /**
     *
     * @param newDate 新的时间
     * @param oldDate 旧的时间
     * @return 新旧时间差
     * @throws ParseException
     */
    public static long getDifferenceofDate(Date newDate,Date oldDate) {
        @SuppressLint("SimpleDateFormat")
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date tempNew = df.parse(df.format(newDate));
            Date tempOld = df.parse(df.format(oldDate));
            return tempNew.getTime() - tempOld.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

