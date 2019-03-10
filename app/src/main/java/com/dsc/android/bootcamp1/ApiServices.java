package com.dsc.android.bootcamp1;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    // just to declare api requests
    // functions will be called where implemented
    // GET (Queries / filters), POST(Secured Body/Parameters - Gmail login/ password), PUT, DELETE

    @GET("v2/5c84deb63300000815f2ba59")
    Call<UserWrapper> getUserList();

}
