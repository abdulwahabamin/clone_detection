    private static void setBackground(@NonNull Context context, @NonNull ImageView imageView, @NonNull Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);

        if (imageView.getDrawable() != null) {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{imageView.getDrawable(), drawable});
            imageView.setImageDrawable(td);
            td.startTransition(200);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

