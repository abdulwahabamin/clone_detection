    private void initView(View view){
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_brief);
        imageView.setImageURI(Uri.fromFile(files[0]));

        ImageView imageDetail = (ImageView) view.findViewById(R.id.imageView_detail);
        imageDetail.setImageURI(Uri.fromFile(files[1]));

        ImageView imageFuture = (ImageView) view.findViewById(R.id.imageView_future);
        imageFuture.setImageURI(Uri.fromFile(files[2]));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareContent shareContent = new ShareContent();
                startActivity(Intent.createChooser(
                        shareContent.startShare(
                                getActivity().getClass().getSimpleName(),
                                files[0]),"分享天气"));
            }
        });

        imageDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareContent shareContent = new ShareContent();
                startActivity(Intent.createChooser(
                        shareContent.startShare(
                                getActivity().getClass().getSimpleName(),
                                files[1]),"分享天气"));
            }
        });

        imageFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareContent shareContent = new ShareContent();
                startActivity(Intent.createChooser(
                        shareContent.startShare(
                                getActivity().getClass().getSimpleName(),
                                files[2]),"分享天气"));
            }
        });

    }

