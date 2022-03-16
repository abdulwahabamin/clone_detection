    /**
     * @see IHttpRequest#make(String, HttpRequestType, IProcessHttpRequest)
     */
    @Override
    public void make(String URL, HttpRequestType method, final IProcessHttpRequest requestProcessor) {
        RequestQueue queue = Volley.newRequestQueue(context);

        // Set the request method
        int requestMethod;
        switch (method) {
            case POST:
                requestMethod = Request.Method.POST;
                break;
            case GET:
                requestMethod = Request.Method.GET;
                break;
            case PUT:
                requestMethod = Request.Method.PUT;
                break;
            case DELETE:
                requestMethod = Request.Method.DELETE;
                break;
            default:
                requestMethod = Request.Method.GET;
        }

        // Execute the request and handle the response
        StringRequest stringRequest = new StringRequest(requestMethod, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        requestProcessor.processSuccessScenario(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        requestProcessor.processFailScenario(error);
                    }
                }
        );

        queue.add(stringRequest);
    }

