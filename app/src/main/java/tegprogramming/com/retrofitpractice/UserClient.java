package tegprogramming.com.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by TroysMacBook on 10/29/17.
 */

public interface UserClient{

    @POST("users")
    Call<User> createAccount(@Body User user);



}
