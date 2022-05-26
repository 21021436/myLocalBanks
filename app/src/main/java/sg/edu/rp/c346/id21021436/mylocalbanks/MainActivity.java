package sg.edu.rp.c346.id21021436.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    //Use static (XML) Context Menus for each bank and inflate them depending on which bank option selected
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        if (view == dbs) {
            getMenuInflater().inflate(R.menu.menu_dbs, menu);
        }
        else if (view == ocbc){
            getMenuInflater().inflate(R.menu.menu_ocbc, menu);
        }
        else if (view == uob){
            getMenuInflater().inflate(R.menu.menu_uob, menu);
        }
    }

    //Below if-else construct handles various bank and context menu options
    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId() == R.id.webSiteDBS){
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsURL)));
            startActivity(implicit);
        }
        else if (item.getItemId() == R.id.contactBankDBS){
            Intent implicit = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsTel)));
            startActivity(implicit);
        }
        else if (item.getItemId() == R.id.webSiteOCBC){
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcURL)));
            startActivity(implicit);
        }
        else if (item.getItemId() == R.id.contactBankOCBC){
            Intent implicit = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcTel)));
            startActivity(implicit);
        }
        else if (item.getItemId() == R.id.webSiteUOB){
            Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobURL)));
            startActivity(implicit);
        }
        else if (item.getItemId() == R.id.contactBankUOB){
            Intent implicit = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobTel)));
            startActivity(implicit);
        }

        return true;
    }

    //Language menu uses Options Menu.
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_language, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.Chinese){
            dbs.setText(R.string.dbsChinese);
            ocbc.setText(R.string.ocbcChinese);
            uob.setText(R.string.uobChinese);
            return true;
        }
        else if (item.getItemId() == R.id.English){
            dbs.setText(R.string.dbs);
            ocbc.setText(R.string.ocbc);
            uob.setText(R.string.uob);
            return true;
        }
        else return true;
    }
}