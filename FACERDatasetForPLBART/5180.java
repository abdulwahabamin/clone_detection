    @Override
    public void onBindViewHolder(BreadCrumbViewHolder holder, int position) {
        holder.name.setText(crumbList.get(position));

        if(breadCrumbsListener!=null){
            holder.root.setOnClickListener(view -> {
                String requiredPath=getRequiredPath(crumbList.get(position));
                if(requiredPath.equals(INVALID_PATHS[0]) || requiredPath.equals(INVALID_PATHS[1]))
                    breadCrumbsListener.onCrumbSelected(null);
                else
                    breadCrumbsListener.onCrumbSelected(getRequiredPath(crumbList.get(position)));
            });
        }
    }

