package com.example.developer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.developer.mode.FactoryMode.ConcreteFactory;
import com.example.developer.mode.FactoryMode.Product;
import com.example.developer.mode.FactoryMode.ProductA;
import com.example.developer.mode.FactoryMode.ProductB;
import com.example.developer.mode.OriginMode.Login;
import com.example.developer.mode.OriginMode.LoginSession;
import com.example.developer.mode.OriginMode.User;

public class ToolBarActionActivity extends AppCompatActivity {

    private static final String TAG = "ToolBarActionActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_action);
        Toolbar toolbar = findViewById(R.id.developer_toolbar_id);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ConcreteFactory factory = new ConcreteFactory();
        Product productA =  factory.createProduct(ProductA.class);
        productA.method();
        Product productB = factory.createProduct(ProductB.class);
        productB.method();
        //test Login
/*        Login login = new Login();
        login.login();
        //test do not use origin mode
        LoginSession loginSession = LoginSession.getInstance();
        User user = loginSession.getUser();
        user.setPassword("56789");
        user.setName("tunzi");
        User.Address address = new User.Address("shanghai");

        User originUser = loginSession.getUser();
        Log.d(TAG,"wangsm,the origin user infor:  " + originUser.toString());*/
        //test end origin mode

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        MenuItem menuItemSearch = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView)menuItemSearch.getActionView();
        MenuItem.OnActionExpandListener actionExpandListener =  new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Log.d(TAG," the action expand");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Log.d(TAG,"the action collapse");
                return true;
            }
        };
       // MenuItemCompat.setOnActionExpandListener(menuItemSearch, (MenuItemCompat.OnActionExpandListener) actionExpandListener);
        menuItemSearch.setOnActionExpandListener(actionExpandListener);
        return super.onCreateOptionsMenu(menu);
    }
}