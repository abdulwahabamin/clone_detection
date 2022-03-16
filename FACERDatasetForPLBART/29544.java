  protected FiveDayWeather(Parcel in) {
    this.id = in.readLong();
    this.dt = in.readInt();
    this.temp = in.readDouble();
    this.minTemp = in.readDouble();
    this.maxTemp = in.readDouble();
    this.weatherId = in.readInt();
    this.timestampStart = in.readLong();
    this.timestampEnd = in.readLong();
    this.color = in.readInt();
    this.colorAlpha = in.readInt();
  }

