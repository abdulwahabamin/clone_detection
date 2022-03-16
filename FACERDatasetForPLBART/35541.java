    public static void drawImage(Context context, int flag) {
        HWeather weather = getData();
        int width = ScreenUtil.getScreenW(context);
        int height = DisplayUtil.dip2px(context, 150);
        int padding = DisplayUtil.dip2px(context, 20);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);//设置画笔颜色
        paint.setStrokeWidth(20.0f);// 设置画笔粗细
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.BOLD);
        paint.setTypeface(font);
        paint.setTextSize(DisplayUtil.sp2px(context, 25));//设置文字大�?
        paint.setTextAlign(Paint.Align.CENTER);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);//设置画笔颜色
        textPaint.setStrokeWidth(20.0f);// 设置画笔粗细
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTypeface(font);
        textPaint.setTextSize(DisplayUtil.sp2px(context, 15));//设置文字大�?
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint verticalLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        verticalLinePaint.setStyle(Paint.Style.STROKE);
        verticalLinePaint.setColor(ContextCompat.getColor(context, R.color.lightgray));
        verticalLinePaint.setAntiAlias(true);
        verticalLinePaint.setStrokeWidth(5);
        verticalLinePaint.setStrokeCap(Paint.Cap.ROUND);
        PathEffect effect = new DashPathEffect(new float[]{1, 2, 4, 8}, 1);
        verticalLinePaint.setPathEffect(effect);
        verticalLinePaint.setStrokeJoin(Paint.Join.ROUND);

        Date sqlDate = mWeatherRepository.getWeatherEntity(mWeatherRepository.getShowCity()).getUpdateTime();
        @SuppressLint("SimpleDateFormat")
        String updateTime = new SimpleDateFormat("MM-dd HH:mm").format(sqlDate);
        String city = WeatherJsonConverter.getWeather(weather).getBasic().getCity();
        String tmp = WeatherJsonConverter.getWeather(weather).getNow().getTmp() + "°";
        String cond = WeatherJsonConverter.getWeather(weather).getNow().getCond().getTxt();

        String tmpRange = WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getTmp().getMin() + "°" + "/" +
                WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getTmp().getMax() + "°";
        String hum = "湿度：" + WeatherJsonConverter.getWeather(weather).getNow().getHum() + "%";
        String speed = "风速：" + WeatherJsonConverter.getWeather(weather).getNow().getWind().getSpd() + "km/h";
        String uv = "紫外线：" + WeatherJsonConverter.getWeather(weather).getSuggestion().getUv().getBrf();
        String[] weeks = new String[7];
        try {
            weeks = DateUtil.
                    getNextWeek(new SimpleDateFormat("yyyy-MM-dd").
                            parse(WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(0).getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] weekTmp = new String[7];
        String[] highTmp = new String[7];
        String[] lowTmp = new String[7];

        File imgFile[] = new File[3];

        switch (flag) {
            case BRIEF:

                canvas.save();
                canvas.drawColor(ContextCompat.getColor(context, R.color.dodgerblue));
                canvas.drawText(city,
                        width - 6 * padding,
                        height - padding,
                        paint);

                canvas.drawText(updateTime,
                        width - 6 * padding,
                        3 * padding,
                        paint);

                canvas.drawText(tmp,
                        3 * padding,
                        height - padding,
                        paint);

                canvas.drawText(cond,
                        3 * padding,
                        3 * padding,
                        paint);

                imgFile[0] = new File(context.getExternalFilesDir(null),
                        "IMG-BRIEF"  + ".png");//创建一个文件
                try {
                    OutputStream os = new FileOutputStream(imgFile[0]);//创建输出�?
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);//通过输出�?将图片�?存

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                canvas.restore();
            case DETAIL:

                canvas.save();
                canvas.drawColor(ContextCompat.getColor(context, R.color.orange));
                canvas.drawText(tmp,
                        3 * padding,
                        2 * padding,
                        paint);

                canvas.drawText(city,
                        width - 6 * padding,
                        2 * padding,
                        paint);

                canvas.drawText(cond,
                        3 * padding,
                        6 * padding,
                        paint);

                canvas.drawText(tmpRange,
                        3 * padding,
                        4 * padding,
                        paint);

                canvas.drawText(hum,
                        width - 6 * padding,
                        4 * padding,
                        textPaint);

                canvas.drawText(speed,
                        width - 6 * padding,
                        5 * padding,
                        textPaint);

                canvas.drawText(uv,
                        width - 6 * padding,
                        6 * padding,
                        textPaint);

                imgFile[1] = new File(context.getExternalFilesDir(null),
                        "IMG-DETAIL" + ".png");//创建一个文件
                try {
                    OutputStream os = new FileOutputStream(imgFile[1]);//创建输出�?
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);//通过输出�?将图片�?存
                  } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                canvas.restore();
            case FUTURE:

                canvas.save();
                canvas.drawColor(ContextCompat.getColor(context, R.color.white));
                for (int i = 0; i < WeatherJsonConverter.getWeather(weather).getDaily_forecast().size(); i++) {
                    weekTmp[i] = WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getCond().getTxt_d();
                    if (weekTmp[i].contains("/")) {
                        weekTmp[i] = weekTmp[i].split("/")[1];
                    }
                    highTmp[i] = "高" + WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getTmp().getMax() + "°";
                    lowTmp[i] = "低" + WeatherJsonConverter.getWeather(weather).getDaily_forecast().get(i).getTmp().getMin() + "°";
                }
                textPaint.setColor(Color.BLACK);
                for (int i = 1; i < 7; i++) {
                    canvas.save();
                    canvas.translate(width * i / 7, 0);
                    canvas.drawLine(0, 0, 0, height, verticalLinePaint);
                    canvas.restore();
                }

                for (int i = 0; i < 7; i++) {
                    canvas.save();
                    canvas.translate(width * i / 7, 0);
                    canvas.drawText(weeks[i],
                            width / 14,
                            2 * padding,
                            textPaint);
                    canvas.drawText(weekTmp[i],
                            width / 14,
                            4 * padding,
                            textPaint);
                    canvas.drawText(highTmp[i],
                            width / 14,
                            6 * padding,
                            textPaint);
                    canvas.drawText(lowTmp[i],
                            width / 14,
                            7 * padding,
                            textPaint);
                    canvas.restore();
                }
                imgFile[2] = new File(context.getExternalFilesDir(null),
                        "IMG-FUTURE"  + ".png");//创建一个文件
                try {
                    OutputStream os = new FileOutputStream(imgFile[2]);//创建输出�?
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);//通过输出�?将图片�?存
                    bitmap.recycle();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                canvas.restore();

        }
    }

