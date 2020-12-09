package com.ssst.stree.problems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ssst.stree.R;
import com.ssst.stree.auth.SignIn;
import com.ssst.stree.auth.SignUp;
import com.ssst.stree.awareness.Awareness;
import com.ssst.stree.financial.Financial;
import com.ssst.stree.security.MainActivity;
import com.ssst.stree.skilldev.SkillDevelopment;

public class Problems extends AppCompatActivity {

    //Initialize variable
    private DrawerLayout drawerLayout;
    private TextView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Problems");
        setContentView(R.layout.activity_problems);

        //Assign Variable
        drawerLayout = findViewById(R.id.drawer_layout);
        profile = findViewById(R.id.profile);
    }

    public void ClickMenu(View view){
        //Open Drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        //Redirect activity to Home
        MainActivity.redirectActivity(this, MainActivity.class);
    }

    public void ClickAwareness(View view){
        //redirect Activity
        MainActivity.redirectActivity(this, Awareness.class);
    }

    public void ClickSkill(View view){
        //Redirect activity to SkillDevelopment
        MainActivity.redirectActivity(this, SkillDevelopment.class);
    }

    public void ClickFinancial(View view){
        //redirect Activity
        MainActivity.redirectActivity(this, Financial.class);
    }

    public void ClickProblems(View view){
        //Recreate this activity
        recreate();
    }

    public void ClickSignIn(View view) {
        //redirect Activity
        MainActivity.redirectActivity(this, SignIn.class);
    }

    public void ClickSignUp(View view) {
        //redirect Activity
        MainActivity.redirectActivity(this, SignUp.class);
    }

    public void ClickSignOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(getApplicationContext(),"Signed Out",Toast.LENGTH_SHORT).show();
        displayName();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayName();
    }

    private void displayName() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            profile.setText(user.getEmail());
        }else {
            profile.setText("Your Profile");
        }
    }
}