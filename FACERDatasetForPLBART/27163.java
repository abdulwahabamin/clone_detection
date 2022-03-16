    @GET("searchJSON")
    Call<GeoCities> findCity(
            @Query("name_startsWith") String cityName,
            @Query("maxRows") int maxRows,
            @Query("lang") String lang,
            @Query("cities") String cities,
            @Query("username") String userName);

