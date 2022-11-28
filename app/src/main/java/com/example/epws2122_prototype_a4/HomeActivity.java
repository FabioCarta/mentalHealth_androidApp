package com.example.epws2122_prototype_a4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name;
    TextView password;
    ImageView profilePic;

    Button login;

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    QuestsFragment questsFragment = new QuestsFragment();
    CommunityFragment communityFragment = new CommunityFragment();
    ProfilFragment profilFragment = new ProfilFragment();

    String personName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();



        name = (TextView) findViewById(R.id.name);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.quests:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,questsFragment).commit();
                        return true;
                    case R.id.community:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,communityFragment).commit();
                        return true;
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profilFragment).commit();
                        return true;
                }
                return false;
            }
        });



        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

/*            Bundle bundle = new Bundle();
            bundle.putString("Name", personName);
            HomeFragment fragobj = new HomeFragment();
            fragobj.setArguments(bundle);
*/

            //name.setText(personName);
            //email.setText(personEmail);
            //System.out.println(personPhoto.toString());
            System.out.println("name: " + personName);
            //Picasso.get().load(personPhoto).into(profilePic);
        }



    }

    public String getPersonName(){
        return personName;
    }

    public void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            }
        });
    }


}