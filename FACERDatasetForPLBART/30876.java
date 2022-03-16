    public static String getCurrentDateTime(String pattern) {
        GregorianCalendar currentCalendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)SimpleDateFormat.getDateTimeInstance();
        simpleDateFormat.applyPattern(pattern);

        return simpleDateFormat.format(currentCalendar.getTime());
    }

