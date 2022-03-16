    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) &&
                Objects.equals(main, weather.main) &&
                Objects.equals(description, weather.description) &&
                Objects.equals(icon, weather.icon);
    }

