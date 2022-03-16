    private int getLayoutResId(Class<?> clazz) {
        if (clazz == RViewHolder.class) {
            return 0;
        }
        RLayout layout = clazz.getAnnotation(RLayout.class);
        if (layout == null) {
            // 找�?到去父类找
            return getLayoutResId(clazz.getSuperclass());
        }
        return layout.value();
    }

