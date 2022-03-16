    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof CityInfo) {
            CityInfo c = (CityInfo) o;
            return TextUtils.equals(c.name, this.name) && c.isAutoLocate == this.isAutoLocate;
        } else {
            return false;
        }
    }

