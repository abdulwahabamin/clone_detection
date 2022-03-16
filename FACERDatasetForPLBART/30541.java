    public void initData(List<HourlyBase> weatherData) {

        hourlyWeatherList = weatherData;
        int size = weatherData.size();
        ITEM_SIZE = size;

        dashLineList = new ArrayList<>();

        Iterator iterator = weatherData.iterator();
        HourlyBase hourlyBase;
        String lastText = "";


        int idx = 0;
        while (iterator.hasNext()) {
            hourlyBase = (HourlyBase) iterator.next();
            if (!hourlyBase.getCond_code().equals(lastText)) {
                if (idx != size - 1) {
                    dashLineList.add(idx);//从0开始添加虚线�?置的索引值idx
                    lastText = hourlyBase.getCond_code();
                }
            }
            idx++;
        }
        dashLineList.add(size - 1);//添加最�?�一�?�虚线�?置的索引值idx
        invalidate();
    }

