    private LyricsLoader(Context con) {
        final OkHttpClient okHttpClient = new OkHttpClient();

        okHttpClient.setCache(new Cache(con.getApplicationContext().getCacheDir(),
                CACHE_SIZE));
        okHttpClient.setConnectTimeout(20, TimeUnit.SECONDS);

        RequestInterceptor interceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                //7-days cache
                request.addHeader("Cache-Control", String.format("max-age=%d,max-stale=%d", Integer.valueOf(60 * 60 * 24 * 7), Integer.valueOf(31536000)));
            }
        };

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_API_URL)
                .setRequestInterceptor(interceptor)
                .setConverter(new Converter() {
                    @Override
                    public Object fromBody(TypedInput arg0, Type arg1)
                            throws ConversionException {

                        try {
                            BufferedReader br = null;
                            StringBuilder sb = new StringBuilder();

                            String line;

                            br = new BufferedReader(new InputStreamReader(arg0.in()));
                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                                sb.append('\n');
                            }
                            return sb.toString();

                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    @Override
                    public TypedOutput toBody(Object arg0) {
                        return null;
                    }
                })
                .setClient(new OkClient(okHttpClient));

        service = builder
                .build()
                .create(LyricsRestService.class);
    }

