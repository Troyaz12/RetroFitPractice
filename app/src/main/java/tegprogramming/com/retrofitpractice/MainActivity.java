package tegprogramming.com.retrofitpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    public Integer id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText)  findViewById(R.id.nameEditText);
        final EditText email = (EditText)  findViewById(R.id.EmailEditText);
        final EditText age = (EditText)  findViewById(R.id.AgeEditText);
        final EditText topics = (EditText)  findViewById(R.id.TopicsEditText);

        Button createAccountButton = (Button) findViewById(R.id.button);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(
                        id,
                        name.getText().toString(),
                        email.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        topics.getText().toString().split(",")
                );

                sendNetworkRequest(user);
            }
        });




    }

    private void sendNetworkRequest(User user){

        //create instance of retrofit
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        //get client and call object for the request
        UserClient client = retrofit.create(UserClient.class);

        Call<User> call = client.createAccount(id,user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this,"User id is: " +response.body().getId(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"something went wrong :( ", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
