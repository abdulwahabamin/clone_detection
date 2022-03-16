    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        County county = (County) o;

        if (name != null ? !name.equals(county.name) : county.name != null) return false;
        if (nameEn != null ? !nameEn.equals(county.nameEn) : county.nameEn != null) return false;
        if (city != null ? !city.equals(county.city) : county.city != null) return false;
        if (province != null ? !province.equals(county.province) : county.province != null)
            return false;
        return code != null ? code.equals(county.code) : county.code == null;

    }

