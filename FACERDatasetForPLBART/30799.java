    @Override
    public boolean equals(Object o) {

        if (o == this) {

            return true;
        }

        if (!(o instanceof CityWeather)) {

            return false;
        }

        CityWeather other = (CityWeather) o;

        return id == other.id;
    }

