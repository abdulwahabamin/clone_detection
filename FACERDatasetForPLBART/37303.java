    @Override
    public void onClick(View v) {
        v.setSelected(true);
        for (View tag : tagViews) {
            if (tag != v) {
                tag.setSelected(false);
            }
        }
    }

