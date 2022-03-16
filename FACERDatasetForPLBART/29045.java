    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return Objects.equals(temp, main.temp) &&
                Objects.equals(pressure, main.pressure) &&
                Objects.equals(humidity, main.humidity) &&
                Objects.equals(tempMin, main.tempMin) &&
                Objects.equals(tempMax, main.tempMax);
    }

