package tegprogramming.com.retrofitpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TroysMacBook on 10/28/17.
 */

public interface GitHubClient {


    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);






}
