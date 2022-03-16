    private static int getResourceForNumber(Context context, float number) {
        int roundedNumber = Math.round(number);
        if (roundedNumber == 0) {
            return R.drawable.zero0;
        } else if (roundedNumber < -60) {
            return R.drawable.less_minus60;
        } else if (roundedNumber > 120) {
            return R.drawable.more120;
        }
        try {
            String fileName;
            if (roundedNumber > 0){
                fileName = "plus" + roundedNumber;
            } else {
                fileName = "minus" + (-roundedNumber);
            }
            Field idField = R.drawable.class.getDeclaredField(fileName);
            return idField.getInt(idField);
        } catch (Exception e) {
            appendLog(context, TAG, "Error getting temperature icon", e);
            return R.drawable.small_icon;
        }
    }

