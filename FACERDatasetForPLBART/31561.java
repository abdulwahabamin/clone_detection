    private boolean getAirQualityTypeAndColor(String airQulityIndexString, AirQulityRepresentation airQulityRepresentation) {
        int airQulityIndex = 0;
        boolean ret = true;
        try {
            airQulityIndex = Integer.parseInt(airQulityIndexString);
        } catch (Exception e) {
            ret = false;
            airQulityRepresentation.setmAirQulityType("---");
            airQulityRepresentation.setmAirQulityColorId(R.color.colorAirOne);
        }

        if (ret) {
            if (airQulityIndex <= 50) {
                airQulityRepresentation.setmAirQulityType("空气优");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirOne);
            } else if (airQulityIndex <= 100) {
                airQulityRepresentation.setmAirQulityType("空气良");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirTwo);
            } else if (airQulityIndex <= 150) {
                airQulityRepresentation.setmAirQulityType("轻度污染");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirThree);
            } else if (airQulityIndex <= 200) {
                airQulityRepresentation.setmAirQulityType("中度污染");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirFour);
            } else if (airQulityIndex <= 300) {
                airQulityRepresentation.setmAirQulityType("�?度污染");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirFive);
            } else {
                airQulityRepresentation.setmAirQulityType("严�?污染");
                airQulityRepresentation.setmAirQulityColorId(R.color.colorAirSix);
            }
        }
        return ret;
    }

