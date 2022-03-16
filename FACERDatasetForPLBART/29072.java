    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(coord, response.coord) &&
                Objects.equals(weather, response.weather) &&
                Objects.equals(base, response.base) &&
                Objects.equals(main, response.main) &&
                Objects.equals(visibility, response.visibility) &&
                Objects.equals(wind, response.wind) &&
                Objects.equals(clouds, response.clouds) &&
                Objects.equals(dt, response.dt) &&
                Objects.equals(sys, response.sys) &&
                Objects.equals(id, response.id) &&
                Objects.equals(name, response.name) &&
                Objects.equals(cod, response.cod);
    }

