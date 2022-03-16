    @Test
    public void queueResponce() throws Exception {
        fetchThreadData.queueResponce("f", "a");
        fetchThreadData.queueResponce("c", "a");
        fetchThreadData.queueResponce("a", "a");
        fetchThreadData.queueResponce("d", "a");
    }

