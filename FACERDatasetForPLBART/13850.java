    public void fetchList(String keyword) {
        Retrofit retrofit = RestUtil.getRetrofit(); //Setting the Retrofit Client

        Api api = retrofit.create(Api.class);   //Creating API using Retrofit Client
        progressBar.setVisibility(View.VISIBLE);
        Call<List<Music>> call = api.getMusics(keyword);    //Making Rest calls for search
        call.enqueue(new Callback<List<Music>>() {
            @Override
            public void onResponse(@NonNull Call<List<Music>> call, @NonNull Response<List<Music>> response) {
                musicList = response.body();    //Building the list of objects from the response
                loadListData();     //Populating the data into listview
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<Music>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

