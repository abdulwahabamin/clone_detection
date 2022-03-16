    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FutureContext context = futureList.get(position);
        ((FutureViewHolder)holder).cond.setText(context.getCond());
        ((FutureViewHolder)holder).tmp.setText(context.getTmp());
        ((FutureViewHolder)holder).wind.setText(context.getWind() + "km/h");
        ((FutureViewHolder)holder).vis.setText(context.getVis() + "km");
        ((FutureViewHolder)holder).pop.setText(context.getPop() + "%");
        ((FutureViewHolder)holder).sunrise.setText(context.getSunrise());
        ((FutureViewHolder)holder).sunset.setText(context.getSunset());
        ((FutureViewHolder)holder).pcpn.setText(context.getPcpn() + "mm");
        ((FutureViewHolder)holder).hum.setText(context.getHum() + "%");
        ((FutureViewHolder)holder).pres.setText(context.getPres() + "帕");
        ((FutureViewHolder)holder).des.setText(context.getDes());
        ((FutureViewHolder)holder).time.setText(context.getTime());
    }

