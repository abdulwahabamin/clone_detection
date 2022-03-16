    private CharSequence getTagText(String tag) {
        int color = R.color.blue_300;
        switch (tag) {
            case "�?物":
                color = R.color.green_300;
                break;
            case "人物":
                color = R.color.orange_300;
                break;
            case "天气":
                color = R.color.blue_300;
                break;
            case "建筑":
                color = R.color.cyan_300;
                break;
            case "动物":
                color = R.color.pink_300;
                break;
        }
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, color));
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append("标签  ");
        int start = ssb.length();
        ssb.append(tag);
        ssb.setSpan(colorSpan, start, ssb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

