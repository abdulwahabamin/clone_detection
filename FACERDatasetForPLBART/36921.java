    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.view_holder_dialy_forecast, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivIcon.setImageResource(ImageUtils.getIconByCode(context, mData.get(position).cond.code_d));
        holder.tvDate.setText(dateFormat(mData.get(position).date));
        holder.tvTemp.setText(context.getString(R.string.daily_forecast_temp, mData.get(position).tmp.min, mData.get(position).tmp.max));
        StringBuilder sb = new StringBuilder();
        sb.append(mData.get(position).cond.txt_d);
        if (!TextUtils.equals(mData.get(position).cond.txt_d, mData.get(position).cond.txt_n)) {
            sb.append("转").append(mData.get(position).cond.txt_n);
        }
        sb.append("，")
                .append(mData.get(position).wind.dir)
                .append(mData.get(position).wind.sc)
                .append(mData.get(position).wind.sc.contains("风") ? "" : "级")
                .append("，")
                .append("紫外线指数")
                .append(getUV(mData.get(position).uv))
                .append("，")
                .append("湿度")
                .append(mData.get(position).hum)
                .append("%，")
                .append("日出")
                .append(mData.get(position).astro.sr)
                .append("，")
                .append("日�?�")
                .append(mData.get(position).astro.ss)
                .append("。");
        holder.tvDetail.setText(sb.toString());
        return convertView;
    }

