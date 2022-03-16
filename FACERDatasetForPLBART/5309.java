    private void setPasteButtonListener() {

        paste.setOnClickListener((view) -> {
            if (selectedList.size() == 0) {
                successDialog("Select a file!!!", CDConstants.WARNING, CDConstants.MEDIUM);
                return;
            }
            options.setImageResource(R.drawable.options);
            operationFlag=true;
            Dialog progressDialog = new Dialog(this);
            progressDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            progressDialog.getWindow().setBackgroundDrawableResource(com.singh.multimeet.quicxplo.R.drawable.curved_back);
            progressDialog.setContentView(com.singh.multimeet.quicxplo.R.layout.progress_view);
            ProgressBar progressBar = progressDialog.findViewById(com.singh.multimeet.quicxplo.R.id.progressBar);
            progressBar.setProgress(0);
            progressBar.setMax(100);
            TextView percentage = progressDialog.findViewById(com.singh.multimeet.quicxplo.R.id.percentage);
            //Log.e(TAG,"Lis size: "+selectedList.size());
            for (FileDirectory file : selectedList) {

                Flowable<Integer> flowable = null;
                FileInputStream inputStream;
                FileOutputStream outputStream;
                try {
                    inputStream = new FileInputStream(new File(file.getPath()));

                    // Checking target Location
                    if ((TARGET_DESTINATION == FileEx.EXTERNAL && SOURCE_DESTINATION == FileEx.INTERNAL)
                            || (TARGET_DESTINATION == FileEx.EXTERNAL && SOURCE_DESTINATION == FileEx.EXTERNAL)) {
                        Log.e(TAG, "destination Path: " + fileEx.getCurrentDir() + "/" + file.getName());

                        Uri treeUri = Uri.parse(sharedPreferences.getString(Util.BASE_URI, ""));

                        pickedDir = Util.getDocumentFile(this,
                                Util.getProcessedPath(fileEx.getCurrentDir())
                                , null, treeUri);

                        if (isCopied) {
                            flowable = copyOrMoveFile(file.getPath(), "", file.getName(), pickedDir, COPY);
                        } else {
                            flowable = copyOrMoveFile(file.getPath(), "", file.getName(), pickedDir, MOVE);
                        }

                        flowable.observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new Subscriber<Integer>() {

                                    @Override
                                    public void onSubscribe(Subscription s) {
                                        progressDialog.show();
                                        s.request(Long.MAX_VALUE);
                                    }

                                    @Override
                                    public void onNext(Integer integer) {
                                        progressBar.setProgress(integer);
                                        percentage.setText("Copying " + integer + "%");
                                    }

                                    @Override
                                    public void onError(Throwable t) {
                                        Log.e(TAG, "Error while subscribing: " + t.getMessage());
                                    }

                                    @Override
                                    public void onComplete() {
                                        filesAdapter.clearSelectedList();
                                        filesAdapter.disableSelection();
                                        paste.setVisibility(View.GONE);
                                        progressDialog.dismiss();
                                        filesAdapter.getOnDirectoryChangeListener()
                                                .onDirectoryChange(loadDirectories());
                                        showOrHideOptions(View.GONE);
                                        successDialog("Success", CDConstants.SUCCESS, CDConstants.NORMAL_TEXT_SIZE);
                                        showOrHideEmptyMessage(View.GONE);
                                        interstitialAd.loadAd(new AdRequest.Builder().build());
                                        isCopied=false;
                                        isMovable=false;
                                    }
                                });
                        return;
                    } else {
                        //Log.e(TAG,"Simple output Stream: ");
                        outputStream = new FileOutputStream(new File(fileEx.getCurrentDir() + "/" + file.getName()));
                    }


                    if (isCopied) {
                        Log.e(TAG, "copy directory: " + fileEx.getCurrentDir());
                        flowable = fileEx.copyOrMoveFile(file.getPath(), inputStream, outputStream, FileEx.COPY);
                    } else {
                        Log.e(TAG, "move directory: " + fileEx.getCurrentDir());
                        flowable = fileEx.copyOrMoveFile(file.getPath(), inputStream, outputStream, FileEx.MOVE);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                flowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new FlowableSubscriber<Integer>() {

                            @Override
                            public void onSubscribe(Subscription s) {
                                progressDialog.show();
                                s.request(Long.MAX_VALUE);
                            }

                            @Override
                            public void onNext(Integer integer) {
                                progressBar.setProgress(integer);
                                percentage.setText("Copying " + integer + "%");
                            }

                            @Override
                            public void onError(Throwable t) {
                                Log.e(TAG, "Error: " + t.getLocalizedMessage());
                            }

                            @Override
                            public void onComplete() {
                                filesAdapter.clearSelectedList();
                                filesAdapter.disableSelection();
                                paste.setVisibility(View.GONE);
                                progressDialog.dismiss();
                                filesAdapter.getOnDirectoryChangeListener()
                                        .onDirectoryChange(loadDirectories());
                                showOrHideOptions(View.GONE);
                                interstitialAd.loadAd(new AdRequest.Builder().build());
                                isCopied=false;
                                isMovable=false;
                            }
                        });
            }
        });
    }

