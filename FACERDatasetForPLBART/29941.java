        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.weather_icon.setText(Utils.setWeatherIcon(context(), horizontalList.get(position).getWeather().get(0).getId()));
            long date1 = horizontalList.get(position).getDt();
            Date expiry = new Date(date1 * 1000);
            String date = new SimpleDateFormat("EE, dd", new Locale(new Prefs(context()).getLanguage())).format(expiry);
            String line2 =
                    horizontalList.get(position).getTemp().getMax() + "°" + "      ";
            String line3 = horizontalList.get(position).getTemp().getMin() + "°";
            String fs = date + "\n" + line2 + line3 + "\n";
            SpannableString ss1 = new SpannableString(fs);
            ss1.setSpan(new RelativeSizeSpan(1.1f), fs.indexOf(date), date.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss1.setSpan(new RelativeSizeSpan(1.4f), fs.indexOf(line2), date.length() + line2.length(), 0);
            holder.details_view.setText(ss1);
            final int pos = position;
            holder.details_view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bottomSheetDialogFragment = newInstance(horizontalList.get(pos));
                    bottomSheetDialogFragment.show(activity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                }
            });
            holder.weather_icon.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    bottomSheetDialogFragment = newInstance(horizontalList.get(pos));
                    bottomSheetDialogFragment.show(activity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                }
            });
            holder.weather_icon.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
            holder.weather_icon.setTypeface(weatherFont);
            holder.details_view.setTextColor(ContextCompat.getColor(context(), R.color.textColor));
        }

