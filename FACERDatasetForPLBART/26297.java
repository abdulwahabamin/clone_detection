    private int getLetterPosition(String letter, List<CityInfoData> allInfoDatas) {
        int position = 0;
        for (CityInfoData cityInfoData : allInfoDatas) {
            if (letter.equalsIgnoreCase(cityInfoData.getInitial())) {
                position = allInfoDatas.indexOf(cityInfoData);
            }
        }
        return position;
    }

