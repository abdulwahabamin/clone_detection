    /**
     * 根�?�具体的时间�?日出日�?�的时间差值 计算出所给时间的百分�?�比
     *
     * @param totalTime 日出日�?�的总时间差
     * @param needTime  当�?时间与日出时间差
     * @return
     */
    private String formatTime(float totalTime, float needTime) {
        if (totalTime == 0)
            return "0.00";
        DecimalFormat decimalFormat = new DecimalFormat("0.00");//�?留2�?�?数，构造方法的字符格�?这里如果�?数�?足2�?,会以0补足.
        return decimalFormat.format(needTime / totalTime);//format 返回的是字符串
    }

