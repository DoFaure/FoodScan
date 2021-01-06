package com.fr.foodscan;

import com.fr.foodscan.model.ProductSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*
public class ProductSearchService {

    private static final long REFRESH_DELAY = 650;
    public static ProductSearchService INSTANCE = new ProductSearchService();
    public static final String ENDPOINT = "https://fr.openfoodfacts.org/api/v0/";

    private final ProductSearchRESTService mProductSearchRESTService;
    private ScheduledExecutorService mScheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture mLastScheduleTask;

    private ProductSearchService() {
        // Create GSON Converter that will be used to convert from JSON to Java
        Gson gsonConverter = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation().create();

        // Create Retrofit client
        Retrofit retrofit = new Retrofit.Builder()
                // Using OkHttp as HTTP Client
                .client(new OkHttpClient())
                // Having the following as server URL
                .baseUrl("https://fr.openfoodfacts.org/api/v0/")
                // Using GSON to convert from Json to Java
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .build();

        // Use retrofit to generate our REST service code
        mProductSearchRESTService = retrofit.create(ProductSearchRESTService.class);
    }

    public void searchProductFromBarcode(final String search) {
        // Cancel last scheduled network call (if any)
        if (mLastScheduleTask != null && !mLastScheduleTask.isDone()) {
            mLastScheduleTask.cancel(true);
        }

        // Schedule a network call in REFRESH_DELAY ms
        mLastScheduleTask = mScheduler.schedule(new Runnable() {
            public void run() {
                mProductSearchRESTService.searchProduct(search).enqueue(new Callback<ProductSearchResult>() {
                    @Override
                    public void onResponse(Call<ProductSearchResult> call, Response<ProductSearchResult> response) {
                        // Post an event so that listening activities can update their UI
                        if (response.body() != null) {
                           //  EventBusManager.BUS.post(response.body().getProduct());
                        } else {
                            // Null result
                            // We may want to display a warning to user (e.g. Toast)

                            Log.e("[ProductSearch] [REST]", "Response error : null body");
                        }
                    }

                    @Override
                    public void onFailure(Call<ProductSearchResult> call, Throwable t) {
                        // Request has failed or is not at expected format
                        // We may want to display a warning to user (e.g. Toast)
                        Log.e("[ProductSearch] [REST]", "Response error : " + t.getMessage());
                    }

                });
            }
        }, REFRESH_DELAY, TimeUnit.MILLISECONDS);
    }
*/
// Service describing the REST APIs
public interface ProductSearchService {

    public static final String ENDPOINT = "https://fr.openfoodfacts.org/api/v0/";

    @GET("product/{barCode}")
    Call<ProductSearchResult> searchProduct(@Path("barCode") String search);
}

