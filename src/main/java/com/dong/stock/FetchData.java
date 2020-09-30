package com.dong.stock;

import com.dong.stock.model.NoFinancialRequestData;
import com.dong.stock.model.StockSimpleInfo;
import com.dong.stock.model.response.ResponseData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class FetchData {

    private Gson mGson;

    public static void main(String[] args) {

    }

    public FetchData() {
        mGson = new Gson();
    }

    public void fetchDataFromApi() {
        NoFinancialRequestData noFinancialRequestData = new NoFinancialRequestData();
        noFinancialRequestData.fsType = "non_financial";
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .build();
        RequestBody requestBody = RequestBody.create(MediaType.get("json"),mGson.toJson(noFinancialRequestData));
        Request request = new Request.Builder()
                .url("https://open.lixinger.com/api/a/stock")
                .post(requestBody)
                .build();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.body() != null) {
                    String responseString = response.body().string();
                    ResponseData<List<StockSimpleInfo>> responseData = mGson.fromJson(responseString, new TypeToken<ResponseData<List<StockSimpleInfo>>>() {
                    }.getType());
                    if (responseData.getCode() == ResponseData.SUCCESS) {

                    }
                }
            }
        });

    }
}
