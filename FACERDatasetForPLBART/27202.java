    public void setImage(@NonNull String fileName) {
        SimpleDraweeView imageView =
                (SimpleDraweeView) getActivity().findViewById(R.id.backdrop);
        if (imageView != null) {
            imageView.setImageURI(Uri.parse("asset:///"+ fileName));
        }
    }

