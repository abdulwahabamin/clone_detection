    @Override
    public Wind getWind() {
        Wind wind = new Wind();
        wind.setDirectionInDegrees(windDirectionInDegrees);
        wind.setSpeed(windSpeed);
        return wind;
    }

