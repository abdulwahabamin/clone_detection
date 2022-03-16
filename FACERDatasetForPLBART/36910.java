    private void setTimeAndPraise() {
        String time = Utils.timeFormat(mImageWeather.getCreatedAt());
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true);
        int color = ContextCompat.getColor(this, typedValue.resourceId);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(time).append("�?摄").append("  ");
        int start = ssb.length();
        ssb.append(String.valueOf(mImageWeather.getPraise()));
        ssb.setSpan(colorSpan, start, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.append("个赞");
        tvTime.setText(ssb);
        tvTime.setMovementMethod(LinkMovementMethod.getInstance());
    }

