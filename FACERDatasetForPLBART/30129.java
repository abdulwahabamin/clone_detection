    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        ForecastBase forecastBase = datas.get(i);
        String condCodeD = forecastBase.getCond_code_d();
        String condCodeN = forecastBase.getCond_code_n();
        String tmpMin = forecastBase.getTmp_min();
        String tmpMax = forecastBase.getTmp_max();
        myViewHolder.tvMax.setText(tmpMax + "°");
        myViewHolder.tvMin.setText(tmpMin + "°");
        myViewHolder.ivDay.setImageResource(IconUtils.getDayIconDark(condCodeD));
        myViewHolder.ivNight.setImageResource(IconUtils.getDayIconDark(condCodeN));
        DateTime now = DateTime.now();
        myViewHolder.tvWeek.setText(getWeek(now.plusDays(i).getDayOfWeek()));
        myViewHolder.tvWeek.setTextColor(context.getResources().getColor(R.color.edit_hint_color));
        if (i == 0) {
            myViewHolder.tvWeek.setText(context.getString(R.string.today));
        }
    }

