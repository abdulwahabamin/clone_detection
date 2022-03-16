    public static SimpleDateFormat getSimpleDateFormat(String format) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            SimpleDateFormat sdf = mSimpleDateFormatCache.get(format);
            if (sdf == null) {
                sdf = new SimpleDateFormat(format);
                mSimpleDateFormatCache.put(format, sdf);
            }

            return sdf;
        } else {
            return new SimpleDateFormat(format);
        }
    }

