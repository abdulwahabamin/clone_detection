    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sys sys = (Sys) o;
        return Objects.equals(type, sys.type) &&
                Objects.equals(id, sys.id) &&
                Objects.equals(message, sys.message) &&
                Objects.equals(country, sys.country) &&
                Objects.equals(sunrise, sys.sunrise) &&
                Objects.equals(sunset, sys.sunset);
    }

