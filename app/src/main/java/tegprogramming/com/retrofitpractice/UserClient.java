package tegprogramming.com.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by TroysMacBook on 10/29/17.
 */

public interface UserClient{

    @PUT("users/{id}")
    Call<User> createAccount(@Path("id") Integer id, @Body User user);



}
