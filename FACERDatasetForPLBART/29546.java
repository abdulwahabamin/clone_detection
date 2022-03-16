  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeLong(this.id);
    dest.writeInt(this.dt);
    dest.writeDouble(this.temp);
    dest.writeDouble(this.minTemp);
    dest.writeDouble(this.maxTemp);
    dest.writeInt(this.weatherId);
    dest.writeLong(this.timestampStart);
    dest.writeLong(this.timestampEnd);
    dest.writeInt(this.color);
    dest.writeInt(this.colorAlpha);
  }

