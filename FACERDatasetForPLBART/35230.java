    @Override
    public void saveWeather(HWeather weather) {
        WeatherEntity entity = new WeatherEntity();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            Date date = simpleDateFormat.parse(WeatherJsonConverter.getWeather(weather).getBasic().getUpdate().getLoc());
            entity.setCityName(WeatherJsonConverter.getWeather(weather).getBasic().getCity());
            entity.setUpdateTime(date);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(weather);
            objectOutputStream.flush();
            byte[] bytes = byteArrayOutputStream.toByteArray();
            entity.setWeather(bytes);
            addWeather(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

